package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

public class CreateAccountPage {


    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCreateAccountForm() {
        return Util.waitForElementPresence(driver, By.id("create-account_form"), 30);
    }

    public WebElement getCreatAccountEmailField() {
        return Util.waitForElementPresence(driver, By.id("email_create"), 30);
    }

    public WebElement getCreateAccountBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 30);
    }

    public void setCreateAccountEmailField(String email) {
        WebElement element = this.getCreatAccountEmailField();
        element.clear();
        element.sendKeys(email);
    }

    /****** ERRORS ******/

    public WebElement getEmailFieldHighlightedRed() {
        return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]"), 30);
    }

    public WebElement getEmailFieldHighlightedGreen() {
        return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]"), 30);
    }

    public WebElement getEmailErrorMessage() {
        return Util.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
    }

    public WebElement getEmailBeenRegistered() {
        return Util.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An account using this email\")]"), 30);
    }
}
