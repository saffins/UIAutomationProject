package com.toptaltest.UI;

import com.toptaltest.UI.pageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.EmailsGenerator;

public class CreateAccountTest  extends BaseClass {



    private LoginPage loginPage;
    private CreateAccountPage createAccount;
    private CreateAccountForm createAccountForm;
    private SignInFormPage signin;
    private AccountPage account;


    @BeforeClass
    public void setup() {
        initialize();
        loginPage = new LoginPage(driver);
        createAccount = new CreateAccountPage(driver);
        createAccountForm = new CreateAccountForm(driver);
        signin = new SignInFormPage(driver);
        account = new AccountPage(driver);
    }



    @Test(priority = 1)
    public void authenticationPage() {
        logger = reports.createTest("authenticationPage");

        loginPage.getSignInBtn().click();
        logger.info("clicked signin button");
        Assert.assertTrue(createAccount.getCreateAccountForm().isDisplayed());
        logger.info("verified created account form");

        Assert.assertTrue(createAccount.getCreatAccountEmailField().isDisplayed());
        logger.info("verified email id in created account form");
        Assert.assertTrue(createAccount.getCreateAccountBtn().isDisplayed());
        logger.info("verified create acount button");
        Assert.assertTrue(signin.getSignInForm().isDisplayed());
        logger.pass("verified signin form");


    }

    @Test(priority = 2)
    public void authenticationPageEmailField() {

        logger = reports.createTest("authenticationPageEmailField");

        createAccount.getCreateAccountBtn().click();

        Assert.assertTrue(createAccount.getEmailErrorMessage().isDisplayed());

        createAccount.setCreateAccountEmailField("testttt");
        createAccount.getCreateAccountBtn().click();

        Assert.assertTrue(createAccount.getEmailErrorMessage().isDisplayed());
        Assert.assertTrue(createAccount.getEmailFieldHighlightedRed().isDisplayed());

        // Registered email
        createAccount.setCreateAccountEmailField(EmailsGenerator.getCurrentEmail());
        createAccount.getCreateAccountBtn().click();

        Assert.assertTrue(createAccount.getEmailBeenRegistered().isDisplayed());

    }

    @Test(priority = 3)
    public void personalInfoFields() {
        logger = reports.createTest("personalInfoFields");

        // Registered email
        createAccount.setCreateAccountEmailField(EmailsGenerator.getRandomEmail());
        createAccount.getCreateAccountBtn().click();
        // With values
        createAccountForm.setCustomerFirstNameField("saffin");
        createAccountForm.setCustomerLastNameField("shiv");
        createAccountForm.setCustomerEmailField("saffin85@gmail.com");
        createAccountForm.setCustomerPasswordField("tester");

        createAccountForm.getAccountCreationForm().click();

        Assert.assertTrue(createAccountForm.getFirstNameHighlightedGreen().isDisplayed());
        Assert.assertTrue(createAccountForm.getLastNameHighlightedGreen().isDisplayed());
        Assert.assertTrue(createAccountForm.getEmailHighlightedGreen().isDisplayed());
        Assert.assertTrue(createAccountForm.getPasswordHighlightedGreen().isDisplayed());

        // Without values
        createAccountForm.setCustomerFirstNameField("");
        createAccountForm.setCustomerLastNameField("");
        createAccountForm.setCustomerEmailField("");
        createAccountForm.setCustomerPasswordField("");

        createAccountForm.getAccountCreationForm().click();

        Assert.assertTrue(createAccountForm.getFirstNameHighlightedRed().isDisplayed());
        Assert.assertTrue(createAccountForm.getLastNameHighlightedRed().isDisplayed());
        Assert.assertTrue(createAccountForm.getEmailHighlightedRed().isDisplayed());
        Assert.assertTrue(createAccountForm.getPasswordHighlightedRed().isDisplayed());
    }


    @AfterClass
    public void closeAll() {

        driver.quit();
    }


}
