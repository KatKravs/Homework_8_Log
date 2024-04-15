package com.ait.qa34;

import com.project.models.NewUser;
import com.project.utils.DataProviders;
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

    @Test(dataProvider = "addNewUserCsvFile", dataProviderClass = DataProviders.class)
    public void addNewUserPositiveTestFromDataProviderWithScvFile(NewUser newuser) {
        app.getNewUser().clickOnRegisterLink();
        app.getNewUser().fillRegisterForm(newuser);
        app.getNewUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

//    @Test
//
////    public void createNewAccountPositivTest() {
////        app.getNewUser().clickOnRegisterLink();
////        app.getNewUser().fillRegisterForm("Tatiana","Kartash","gsgs@gmai.com","Hgf435_s","Hgf435_s");
////        app.getNewUser().fillRandomRegisterForm("katkate@gmail.com", "Sa12345!");
////        app.getNewUser().clickOnRegisterButton();
////        app.getNewUser().clickOnContinueButton();
////        Assert.assertTrue(app.getUser().isAccountLinkPresent());
////        System.out.println(app.getUser().isAccountLinkPresent());
////    }

}
