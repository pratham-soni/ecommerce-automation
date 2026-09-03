package com.ecommerce.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.automation.base.BaseTest;
import com.ecommerce.automation.driver.DriverFactory;
import com.ecommerce.automation.pages.LoginPage;
import com.ecommerce.automation.pages.ProductsPage;

public class LoginTest extends BaseTest {
    
    @Test
    public void userShouldLoginSuccessfully(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

        loginPage.open();

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(productsPage.isProductPageDisplayed(),"Product page should be displayed after successfull login");
    }
}
