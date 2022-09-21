package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

public class LoginPage {


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getSignInBtn() {
        return Util.waitForElementPresence(driver, By.id("SubmitLogin"), 30);
    }




}
