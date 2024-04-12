package com.project.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isProductAdded(String text) {
        List<WebElement> products = driver.findElements(By.cssSelector("a"));
        for (WebElement element : products) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String takeScreenshot(){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenschot = new File("screenshots/screen-"+System.currentTimeMillis()+".png");
        try {
            Files.copy(tmp,screenschot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenschot.getAbsolutePath();
    }
}


