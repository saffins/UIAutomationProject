package com.toptaltest.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

public class SignInFormPage {
	
	private WebDriver driver;
	
	public SignInFormPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInForm() {
		return Util.waitForElementPresence(driver, By.id("login_form"), 30);
	}
	
	public WebElement getSignInEmailField() {
		return Util.waitForElementPresence(driver, By.id("email"), 30);
	}
	
	public WebElement getSignInPasswordField() {
		return Util.waitForElementPresence(driver, By.id("passwd"), 30);
	}
	
	public WebElement getSignInBtn() {
		return Util.waitForElementPresence(driver, By.id("SubmitLogin"), 30);
	}
	
	
	public void setEmailField(String mail) {
		WebElement email = this.getSignInEmailField();
		email.clear();
		email.sendKeys(mail);
	}
	
	public void setPasswordField(String pass) {
		WebElement password = this.getSignInPasswordField();
		password.clear();
		password.sendKeys(pass);
	}
	
	/****** ERRORS ******/
	
	public WebElement getEmailRequiredError() {
		return Util.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An email address required.\")]"), 30);
	}
	
	public WebElement getEmailInvalidError() {
		return Util.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
	}
	
	public WebElement getAuthenticationFailedError() {
		return Util.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Authentication failed.\")]"), 30);
	}
	public WebElement getPasswordRequiredError() {
		return Util.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Password is required.\")]"), 30);
	}
	
	public WebElement getInvalidPasswordError() {
		return Util.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid password\")]"), 30);
	}
	
	/****** HIGHLIGHTED ERRORS ******/
	
	public WebElement getEmailHighlightedRed() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]//input[@id=\"email\"]"), 30);
	}
	
	public WebElement getEmailHighlightedGreen() {
		return Util.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]//input[@id=\"email\"]"), 30);
	}
}
