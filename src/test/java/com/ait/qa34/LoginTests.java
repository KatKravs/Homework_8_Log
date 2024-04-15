package com.ait.qa34;

import com.project.models.NewUser;
import com.project.models.User;
import com.project.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("1730siyabest1@gmail.com")
                .setPassword("Sa12345!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @Test
    public void loginNegativeTestWithOutEmail() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm( new User().setPassword("Sa12345!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isValidationSummaryErrorsPresent());
    }
    @Test(dataProvider = "addNewUserCsvFile", dataProviderClass = DataProviders.class)
    public void addNewUserPositiveTestFromDataProviderWithScvFile(NewUser newuser) {
        app.getNewUser().clickOnRegisterLink();
        app.getNewUser().fillRegisterForm(newuser);
        app.getNewUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

}
