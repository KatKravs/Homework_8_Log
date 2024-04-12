package com.ait.qa34;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test

    public void createNewAccountPositivTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm("John", "Smith");
        app.getUser().fillRandomRegisterForm("katkate@gmail.com", "Sa12345!");
        app.getUser().clickOnRegisterButton();
        app.getUser().clickOnContinueButton();
        Assert.assertTrue(app.getUser().isAccountLinkPresent());
        System.out.println(app.getUser().isAccountLinkPresent());
    }

}
