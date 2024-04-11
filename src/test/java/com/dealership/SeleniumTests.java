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
}