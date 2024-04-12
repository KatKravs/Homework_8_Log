package com.ait.qa34;

import com.project.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class HWSeleniumTest {

    WebDriver driver;

    @BeforeMethod(enabled = false)
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    @Test(enabled = false)
    public void findElementsByTagName() {

        WebElement element1 = driver.findElement(By.tagName("title"));
        String titleText = element1.getAttribute("innerHTML");
        System.out.println("Текст первого элемента (тег 'title'): " + titleText);


        List<WebElement> elements1 = driver.findElements(By.tagName("title"));

        System.out.println("Общее количество элементов с тегом 'title': " + elements1.size());


        WebElement element2 = driver.findElement(By.tagName("input"));
        System.out.println("Тип второго элемента (тег 'input'): " + element2.getAttribute("type"));


        List<WebElement> elementsInput = driver.findElements(By.tagName("input"));

        System.out.println("Общее количество элементов с тегом 'input': " + elementsInput.size());


        WebElement element3 = driver.findElement(By.tagName("h2"));
        System.out.println("Текст третьего элемента (тег 'h2'): " + element3.getText());


        List<WebElement> elementsH2 = driver.findElements(By.tagName("h2"));

        System.out.println("Общее количество элементов с тегом 'h2': " + elementsH2.size());
    }

    @Test(enabled = false)
    public void findAllTags() {

        List<WebElement> allElements = driver.findElements(By.xpath("//*"));


        System.out.println("Общее количество тегов на странице: " + allElements.size());
    }

    @Test(enabled = false)
    public void findTenDifferentElementsByCssSelector() {
        // id -> #id
        driver.findElement(By.cssSelector("#flyout-cart"));
        driver.findElement(By.cssSelector("#newsletter-subscribe-block"));

        driver.findElement(By.cssSelector(".header-links-wrapper"));
        driver.findElement(By.cssSelector(".header-logo"));

        driver.findElement(By.cssSelector("[name='q']"));
        driver.findElement(By.cssSelector("[data-valmsg-for='NewsletterEmail']"));
        driver.findElement(By.cssSelector("[href='/']"));
        // contains -> *
        driver.findElement(By.cssSelector("[href*='viewed']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/about']"));
        //end on -> $
        driver.findElement(By.cssSelector("[href$='/apparel']"));

    }

    @Test(enabled = false)
    public void findTenDiffferentElementsByXpath() {
        // id -> //tag[@id='idName']
        driver.findElement(By.xpath("//*[@id='flyout-cart']"));
        driver.findElement(By.xpath("//*[@id='newsletter-subscribe-block']"));
        // class name -> //tag[@class='className']
        driver.findElement(By.xpath("//*[@class='header-links-wrapper']"));
        driver.findElement(By.xpath("//*[@class='header-logo']"));
        // name -> //*[@name='...']
        driver.findElement(By.xpath("//*[@name='q']"));
        driver.findElement(By.xpath("//*[@data-valmsg-for='NewsletterEmail']"));
        driver.findElement(By.xpath("//*[@href='/']"));
        // contains -> //*[contains(@attr,'...')]
        driver.findElement(By.xpath("//*[contains(@href, 'viewed')]"));
        //start -> //*[starts-with(@attr,'...')]
        driver.findElement(By.xpath("//*[starts-with(@href, '/about')]"));
        // end on -> //*[substring(@href, string-length(@href) - string-length('...') +1) = '...']
        driver.findElement(By.xpath("//*[substring(@href, string-length(@href) - string-length('/apparel') +1) = '/apparel']"));
    }

}
