package com.project.fw;

import com.project.models.NewUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RegestrationHelper extends BaseHelper{
    public RegestrationHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

//    public void fillRandomRegisterForm(String mail, String password) {
////        Random random = new Random();
////        int i = random.nextInt(1000) + 1000;
//        type(By.id("Email"), +i + mail);
//        type(By.id("Password"), password);
//        type(By.id("ConfirmPassword"), password);
//    }
    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }
    public void fillRegisterForm(NewUser newUser) {
        type(By.id("FirstName"), newUser.getFirstName());
        type(By.id("LastName"), newUser.getLastName());
        type(By.id("Email"),   newUser.getEmail());
        type(By.id("Password"), newUser.getPassword());
        type(By.id("ConfirmPassword"), newUser.getConfirmPassword());
    }
    public void clickOnContinueButton() {
        click(By.cssSelector(".button-1.register-continue-button"));
    }

}
