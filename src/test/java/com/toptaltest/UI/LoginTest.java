package com.toptaltest.UI;

import com.toptaltest.UI.pageObject.AccountPage;
import com.toptaltest.UI.pageObject.CreateAccountForm;
import com.toptaltest.UI.pageObject.SignInFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.EmailsGenerator;


public class LoginTest extends BaseClass {

    CreateAccountForm createAccountForm;
    SignInFormPage signin;
    AccountPage account;


    @BeforeClass
    public void setup() {

        logger.info("starting " + getClass().getSimpleName()+ " test");
        initialize();
        createAccountForm = new CreateAccountForm(driver);
        signin = new SignInFormPage(driver);
        account = new AccountPage(driver);
    }

    @Test(priority = 1)
    public void loginPageElements() {
        logger = reports.createTest("loginPageElements");

        Assert.assertTrue(signin.getSignInForm().isDisplayed());
        Assert.assertTrue(signin.getSignInEmailField().isDisplayed());
        Assert.assertTrue(signin.getSignInPasswordField().isDisplayed());
        Assert.assertTrue(signin.getSignInBtn().isEnabled());
        logger.info("verified signin form");
    }

    @Test(priority = 2)
    public void invalidCredentials() {
        logger = reports.createTest("invalidCredentials");

        logger.info("validating invalid credentials test");
        signin.setEmailField("invalid@email.com");
        signin.setPasswordField("invalid");
        signin.getSignInBtn().click();

        Assert.assertTrue(signin.getAuthenticationFailedError().isDisplayed());
        logger.info("invalid credentials test verified successfully");


    }

    @Test(priority = 3)
    public void loginWithoutCredentials() {
        logger = reports.createTest("loginWithoutCredentials");

        signin.setEmailField("");
        signin.setPasswordField("test123");
        signin.getSignInBtn().click();

        Assert.assertTrue(signin.getEmailRequiredError().isDisplayed());

        signin.setEmailField("asasas@gmail.com");
        signin.setPasswordField("");
        signin.getSignInBtn().click();

        Assert.assertTrue(signin.getPasswordRequiredError().isDisplayed());

        signin.setEmailField("");
        signin.setPasswordField("");
        signin.getSignInBtn().click();

        Assert.assertTrue(signin.getEmailRequiredError().isDisplayed());
    }

    @Test(priority = 4)
    public void emailFormat() {

        logger = reports.createTest("emailFormat");

        signin.setEmailField("email");
        signin.getSignInPasswordField().click();

        Assert.assertTrue(signin.getEmailHighlightedRed().isDisplayed());

        signin.setEmailField("email@email");
        signin.getSignInPasswordField().click();

        Assert.assertFalse(signin.getEmailHighlightedRed().isDisplayed());

        signin.setEmailField("email@email.email");
        signin.getSignInPasswordField().click();

        Assert.assertTrue(signin.getEmailHighlightedGreen().isDisplayed());
    }

    @Test(priority = 5)
    public void successfulLogin() {

        logger = reports.createTest("successfulLogin");

        signin.setEmailField(EmailsGenerator.getCurrentEmail());
        signin.setPasswordField("saffin123");
        signin.getSignInBtn().click();

        Assert.assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
        account.getAccountLogout().click();

    }

    @AfterClass
    public void closeAll() {
        driver.quit();
    }


}
