package com.dealership;

    
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {
    static WebDriver driver = new ChromeDriver();

    @Test
    public void example() {

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
        driver.get("http://localhost:8080/");
        String title = driver.getTitle();
        assertEquals("Dealership", title);
        driver.quit();
    }

    @Test
    public void modelsPage(){
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
    public void postQuery(){
        driver.get("http://localhost:8080/createOrder?configurationId=4");
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("n");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("e");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("p");

        WebElement submit = driver.findElement(By.cssSelector("button"));
        submit.click();
        driver.quit();
    }

    @Test
    public void getQuery(){
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
        driver.get("http://localhost:8080/admin/models");
        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> rows = table.findElement(By.tagName("tbody"))
                                     .findElements(By.tagName("tr"));
        rows.get(0).findElement(By.id("brand"));
        rows.get(0).findElement(By.id("model"));
        rows.get(0).findElement(By.id("save")).click();
        driver.quit();
    }

    @Test
    public void loginPage(){
        driver.get("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys("u");
        driver.findElement(By.id("password")).sendKeys("p");
        driver.findElement(By.cssSelector("button")).click();
        driver.quit();
    }

    @Test
    public void userExp(){
        driver.get("http://localhost:8080/model?modelId=3");
        driver.findElement(By.linkText("Order")).click();
        driver.quit();
    }
}