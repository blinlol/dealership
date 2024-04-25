package com.dealership;
    
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import com.dealership.services.*;
import com.dealership.models.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {

    @Test
    public void example() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();
    }

    @Test
    public void mainPage(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        String title = driver.getTitle();
        assertEquals("Dealership", title);
        driver.quit();
    }

    @Test
    public void modelsPage(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/models");
        WebElement table = driver.findElement(By.id("models_table"));
        List<WebElement> thead = table.findElements(By.tagName("th"));
        assertEquals(2, thead.size());
        assertEquals("Brand", thead.get(0).getText());
        assertEquals("Model", thead.get(1).getText());
        driver.findElement(By.linkText("Vesta")).click();
        driver.quit();
    }

    @Test
    public void modelsCount(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/models");
        List<WebElement> rows = driver.findElement(By.cssSelector("tbody"))
                                 .findElements(By.cssSelector("tr"));

        ModelService ms = new ModelService();
        assertEquals(ms.findAll().size(), rows.size());
        driver.quit();
    }

    

    private void login(WebDriver driver){
        driver.get("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys("u");
        driver.findElement(By.id("password")).sendKeys("p");
        driver.findElement(By.cssSelector("button")).click();
    }

    @Test
    public void postQuery(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/createOrder?configurationId=4");
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("n");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("e@mail.ru");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("p");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        driver.quit();

        RequestService rs = new RequestService();
        List<Request> all_req = rs.findAll();
        boolean found = false;
        for(Request r : all_req){
            if(r.getClientName().equals("n") && r.getClientEmail().equals("e@mail.ru") && r.getClientPhone().equals("p")){
                found = true;
                rs.deleteById(r.getId());
            }
        }
        assertEquals(true, found);
    }

    @Test
    public void getQuery(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/model?modelId=3");
        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> thead = table.findElements(By.tagName("th"));
        assertEquals(4, thead.size());
        assertEquals("Name", thead.get(0).getText());
        assertEquals("Price", thead.get(2).getText());
        driver.findElement(By.cssSelector("button")).click();
        driver.quit();
    }

    @Test
    public void adminPage(){
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get("http://localhost:8080/admin/models");
        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> rows = table.findElement(By.tagName("tbody"))
                                     .findElements(By.tagName("tr"));
        rows.get(0).findElement(By.id("brand"));
        rows.get(0).findElement(By.id("model"));
        rows.get(0).findElement(By.id("save")).click();

        ModelService ms = new ModelService();
        assertEquals(ms.findAll().size() + 1, rows.size());
        
        driver.quit();
    }

    @Test
    public void addModel(){
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get("http://localhost:8080/admin/models");
        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> rows = table.findElement(By.tagName("tbody"))
                                     .findElements(By.tagName("tr"));

        WebElement last = rows.getLast();
        last.findElement(By.id("brand")).sendKeys("Lada");
        last.findElement(By.id("model")).sendKeys("TEST");
        last.findElement(By.cssSelector("button")).click();
        driver.quit();

        ModelService ms = new ModelService();
        Model m = ms.findByName("TEST");
        assertEquals("Lada", m.getBrand().getName());
        ms.delete(m);   
    }

    @Test
    public void loginPage(){
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.quit();
    }

    @Test
    public void userExp(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/model?modelId=3");
        driver.findElement(By.linkText("Order")).click();
        driver.quit();
    }
}