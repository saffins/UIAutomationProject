package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

import java.util.List;

public class CartPage {


    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCartTab() {
        return Util.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"Cart\")]/.."), 30);
    }



    public WebElement getCartShipingCost() {
        return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"cart-prices\"]//span[contains(.,\"$2.00\")]"), 30);
    }

    public WebElement getCartTotalPrice() {
        return Util.waitForElementPresence(driver, By.xpath("//span[@class=\"price cart_block_total ajax_block_cart_total\"]"), 30);
    }

    public WebElement getCartTabCheckOutBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//a[@id=\"button_order_cart\"]/span[contains(text(), \"Check out\")]"), 30);
    }

    public List<WebElement> getCartProductsQty() {
        return driver.findElements(By.xpath("//dt"));
    }
}
