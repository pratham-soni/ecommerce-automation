package com.ecommerce.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.automation.base.BaseTest;
import com.ecommerce.automation.driver.DriverFactory;
import com.ecommerce.automation.pages.CartPage;
import com.ecommerce.automation.pages.CheckOutPage;
import com.ecommerce.automation.pages.LoginPage;
import com.ecommerce.automation.pages.OrderConfirmationPage;
import com.ecommerce.automation.pages.ProductsPage;

public class UserPurchaseTest extends BaseTest {
    
    @Test
    public void userShouldCompletePurchaseSuccessfully(){

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        CartPage cartPage = new CartPage(DriverFactory.getDriver());
        CheckOutPage checkOutPage = new CheckOutPage(DriverFactory.getDriver());
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverFactory.getDriver());

        loginPage.open();

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(productsPage.isProductPageDisplayed(),"Product page should be displayed after successfull login");
        
        productsPage.addBackPacktoCart();
        productsPage.openCart();

        Assert.assertTrue(cartPage.isCartPageDisplayed(),"cart page should be displayed");

        Assert.assertTrue(cartPage.isBackpackDisplayed(),"back pack should be displayed");

        cartPage.clickCheckout();

        Assert.assertTrue(checkOutPage.isCheckOutPageDisplayed(),"Checkout page should be displayed");
        
        checkOutPage.enterFirstName("kartik");
        checkOutPage.enterLastName("kuswaha");
        checkOutPage.enterPostalCode("221005");

        checkOutPage.clickContinue();

        Assert.assertTrue(checkOutPage.isCheckOutOverviewDisplayed(),"checkout overview should be present");

        checkOutPage.clickFinishBtn();

        Assert.assertTrue(orderConfirmationPage.isOrderConfirmed(),"order should be confirmed");

        Assert.assertEquals(orderConfirmationPage.getConfirmationMesssege(), "Thank you for your order!");

    }
}
