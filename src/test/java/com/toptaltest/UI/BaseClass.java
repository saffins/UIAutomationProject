package com.toptaltest.UI;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.toptaltest.UI.pageObject.AccountPage;
import com.toptaltest.UI.pageObject.CreateAccountForm;
import com.toptaltest.UI.pageObject.SignInFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.Helper;

import java.io.File;
import java.io.IOException;

import static utils.Helper.captureScreenshot;

public class BaseClass {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void initalizeExtentReporter() {
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/extentNew" + Helper.getCurrentDateTime() + ".html"));
        reports = new ExtentReports();
        reports.attachReporter(extent);
    }


    public static void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String baseUrl = "http://automationpractice.com/index.php?controller=authentication";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }



    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver);
            logger.fail("Test Failed " + result.getMethod().getMethodName(), MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.pass("Test case passed " + result.getMethod().getQualifiedName());
        }


    }

    @AfterSuite
    public void tearDown() {
        System.out.println("ended");
        reports.flush();
    }


}
