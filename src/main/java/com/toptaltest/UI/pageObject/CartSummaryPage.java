package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

import java.util.List;


public class CartSummaryPage {


    private WebDriver driver;

    public CartSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCartSummaryTable() {
        return Util.waitForElementPresence(driver, By.id("cart_summary"), 30);
    }

    public WebElement getCartSummUnitPrice(int numOfProduct) {
        return Util.waitForElementPresence(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price special-price\"]"), 30);
    }

    public WebElement getCartSummSpecialUnitPrice(int numOfProduct) {
        return Util.waitForElementPresence(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price\"]/span[@class=\"price special-price\"]"), 30);
    }

    public WebElement getCartSummQtyInput(int numOfProduct) {
        return Util.waitForElementPresence(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//input[@type=\"text\"]"), 30);
    }


}
