package com.toptaltest.UI;

import com.toptaltest.UI.pageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.EmailsGenerator;

public class ShopFlowTest extends BaseClass {

    private Actions action;

    private ClothesPage clothes;
    private SignInFormPage signInFormPage;
    private CartPage cart;
    private ShoppingActionsPage shoppingActions;
    private CartSummaryPage summary;
    private LoginPage signinForm;
    private AccountPage account;

    @BeforeClass
    public void setup() {

        initialize();
        logger.info("starting " + getClass().getSimpleName()+ " test" );
        action = new Actions(driver);

        clothes = new ClothesPage(driver);
        cart = new CartPage(driver);
        shoppingActions = new ShoppingActionsPage(driver);
        signInFormPage = new SignInFormPage(driver);
        summary = new CartSummaryPage(driver);
        account = new AccountPage(driver);


    }


    @Test(priority = 1)
    public void selectClothes() {
        logger = reports.createTest("selectClothes");

        Assert.assertTrue(clothes.getDressesBtn().isDisplayed());

        action.moveToElement(clothes.getDressesBtn()).perform();

        Assert.assertTrue(clothes.getSummerDressesBtn().isDisplayed());
        Assert.assertTrue(clothes.getCasualDressesBtn().isDisplayed());
        Assert.assertTrue(clothes.getEveningDressesBtn().isDisplayed());

        action.moveToElement(clothes.getSummerDressesBtn()).perform();
        clothes.getSummerDressesBtn().click();
        logger.info("adding summer dress into cart");

        Assert.assertTrue(clothes.getSummerDressProduct(1).isDisplayed());
        Assert.assertTrue(clothes.getSummerDressProduct(2).isDisplayed());
        Assert.assertTrue(clothes.getSummerDressProduct(3).isDisplayed());
        Assert.assertEquals(clothes.getDressesCount().size(), 3);

        action.moveToElement(clothes.getSummerDressProduct(1)).perform();
        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();

        Assert.assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());
        logger.info("clicking on add to cart button");
        action.click(shoppingActions.getAddToCartBtn()).build().perform();
        logger.info("clicked on add to cart button");

        action.click(shoppingActions.getContinueShopingBtn()).build().perform();

        Assert.assertTrue(shoppingActions.getContinueShopingBtn().isDisplayed());
        Assert.assertEquals(cart.getCartProductsQty().size(), 1);
        logger.pass("found cart products quantity "+ cart.getCartProductsQty().size());


    }

    @Test(priority = 2)
    public void checkingCartProductsQtyAndPrice() {
        logger = reports.createTest("checkingCartProductsQtyAndPrice");

        logger.info("moving to cart to check price");
        action.moveToElement(cart.getCartTab()).perform();

        Assert.assertEquals(cart.getCartShipingCost().getText(), "$2.00");
        logger.pass("shipping cost verified");
        action.moveToElement(cart.getCartTotalPrice()).perform();

        Assert.assertEquals(cart.getCartTotalPrice().getText(), "$30.98");
        logger.pass("total cost verified");

    }


    @AfterClass
    public void closeAll() {
        driver.quit();
    }

}
