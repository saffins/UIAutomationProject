package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Util;

public class CreateAccountForm {
	
	private WebDriver driver;
	
	public CreateAccountForm(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getAccountCreationForm() {
		return Util.waitForElementPresence(driver, By.id("account-creation_form"), 30);
	}
	

	public WebElement getCustomerFirstNameField() {
		return Util.waitForElementPresence(driver, By.id("customer_firstname"), 30);
	}
	
	public WebElement getCustomerLastNameField() {
		return Util.waitForElementPresence(driver, By.id("customer_lastname"), 30);
	}
	
	public WebElement getCustomerEmailField() {
		return Util.waitForElementPresence(driver, By.id("email"), 30);
	}
	
	public WebElement getCustomerPasswordField() {
		return Util.waitForElementPresence(driver, By.id("passwd"), 30);
	}

	public WebElement successfullyCreatedAccount() {
		return Util.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Welcome to your account.\")]"), 30);
	}

	
	

	public void setCustomerFirstNameField(String firstName) {
		WebElement customerFirstNameField = this.getCustomerFirstNameField();
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(firstName);
	}
	
	public void setCustomerLastNameField(String lastName) {
		WebElement customerLastNameField = this.getCustomerLastNameField();
		customerLastNameField.clear();
		customerLastNameField.sendKeys(lastName);
	}
	
	public void setCustomerEmailField(String email) {
		WebElement customerEmailField = this.getCustomerEmailField();
		customerEmailField.clear();
		customerEmailField.sendKeys(email);
	}
	
	public void setCustomerPasswordField(String password) {
		WebElement customerPasswordField = this.getCustomerPasswordField();
		customerPasswordField.clear();
		customerPasswordField.sendKeys(password);
	}
	


	
	public WebElement getFirstNameHighlightedGreen() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_firstname\"]"), 30);
	}
	
	public WebElement getFirstNameHighlightedRed() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_firstname\"]"), 30);
	}
	
	public WebElement getLastNameHighlightedGreen() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_lastname\"]"), 30);
	}
	
	public WebElement getLastNameHighlightedRed() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_lastname\"]"), 30);
	}
	
	public WebElement getEmailHighlightedGreen() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"email\"]"), 30);
	}
	
	public WebElement getEmailHighlightedRed() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"email\"]"), 30);
	}
	
	public WebElement getPasswordHighlightedGreen() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"required password form-group form-ok\"]//input[@id=\"passwd\"]"), 30);
	}
	
	public WebElement getPasswordHighlightedRed() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"required password form-group form-error\"]//input[@id=\"passwd\"]"), 30);
	}
	
}
