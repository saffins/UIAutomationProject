package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

import java.util.List;


public class ClothesPage {

    private WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getWomenBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"), 30);
    }

    public WebElement getDressesBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), 30);
    }

    public WebElement getTShirtsBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]"), 30);
    }

    public WebElement getDressesDropDown() {
        return Util.waitForElementPresence(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul"), 30);
    }

    public WebElement getCasualDressesBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Casual Dresses\")]"), 30);
    }

    public WebElement getEveningDressesBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Evening Dresses\")]"), 30);
    }

    public WebElement getSummerDressesBtn() {
        return Util.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"), 30);
    }

     public WebElement getCasualDressProduct(int dressNum) {
        return Util.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);
    }

     public WebElement getEveningDressProduct(int dressNum) {
        return Util.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);
    }

     public WebElement getSummerDressProduct(int dressNum) {
        return Util.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);
    }

    public List<WebElement> getDressesCount() {
        return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
    }
}
