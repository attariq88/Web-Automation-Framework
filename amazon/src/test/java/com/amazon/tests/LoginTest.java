package com.amazon.tests;

import com.amazon.data.DataProvidersForTests;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private static Logger LOGGER = Logger.getLogger(LoginTest.class);

    private HomePage homePage;
    private SignInPage signInPage;
    private CreateAccountPage createAccountPage;
    @BeforeMethod
    public void setPOM(){
        homePage = PageFactory.initElements(driver,HomePage.class);
        signInPage = PageFactory.initElements(driver,SignInPage.class);
        createAccountPage = PageFactory.initElements(driver,CreateAccountPage.class);
    }

    @Test(dataProviderClass = DataProvidersForTests.class, dataProvider = "getDataForLoginTest")
    public void validateUserCanCreateAccount(String userName, String email, String password){

        homePage.clickOnSignButton();
        ExtentTestManager.log("Sign in button click",LOGGER);
        signInPage.clickOnCreateAccountButton();
        ExtentTestManager.log("Sign in button click.",LOGGER);

        createAccountPage.typeInNameField(userName);
        createAccountPage.typeInEmailField(email);
        createAccountPage.typeInPasswordField(password);
        createAccountPage.typeInReEnterPassField(password);

        sleepFor(5);
    }
}
