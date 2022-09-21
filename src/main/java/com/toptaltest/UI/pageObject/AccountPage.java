package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

import java.util.List;

public class AccountPage {


    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAccountBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//a[@title=\"View my customer account\"]"), 30);
    }

    public WebElement getAccountLogout() {
        return Util.waitToBeClickable(driver, By.xpath("//a[@title=\"Log me out\"]"), 30);
    }



}
