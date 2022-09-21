package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

public class ShoppingActionsPage {

    private WebDriver driver;

    public ShoppingActionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddToCartBtn() {
        return Util.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]"), 30);
    }

    public WebElement getAddedToCartModal() {
        return Util.waitForElementPresence(driver, By.id("layer_cart"), 30);
    }

    public WebElement getContinueShopingBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//span[@title=\"Continue shopping\"]"), 30);
    }


}
