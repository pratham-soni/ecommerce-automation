package com.ecommerce.automation.stepdefinitions;

import com.ecommerce.automation.driver.DriverFactory;
import com.ecommerce.automation.pages.CartPage;
import com.ecommerce.automation.pages.CheckOutPage;
import com.ecommerce.automation.pages.LoginPage;
import com.ecommerce.automation.pages.OrderConfirmationPage;
import com.ecommerce.automation.pages.ProductsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

public class PurchaseSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;
    private OrderConfirmationPage orderConfirmationPage;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {

        System.out.println(">>> CUCUMBER: User is on login page");

        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.open();
    }

    @When("the user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {

        System.out.println(">>> CUCUMBER: User is logging in");

        productsPage = new ProductsPage(DriverFactory.getDriver());

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(
                productsPage.isProductPageDisplayed(),
                "Products page should be displayed after login.");
    }

    @When("the user adds the backpack to the cart")
    public void userAddsBackpackToCart() {

        productsPage.addBackPacktoCart();
    }

    @When("the user proceeds to checkout")
    public void userProceedsToCheckout() {

        cartPage = new CartPage(DriverFactory.getDriver());

        productsPage.openCart();

        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page should be displayed.");

        Assert.assertTrue(
                cartPage.isBackpackDisplayed(),
                "Backpack should be displayed in the cart.");

        cartPage.clickCheckout();
    }

    @When("the user enters valid customer details")
    public void userEntersValidCustomerDetails() {

        checkOutPage = new CheckOutPage(DriverFactory.getDriver());

        Assert.assertTrue(
                checkOutPage.isCheckOutPageDisplayed(),
                "Checkout page should be displayed.");

        checkOutPage.enterFirstName("kartik");
        checkOutPage.enterLastName("kuswaha");
        checkOutPage.enterPostalCode("221005");

        checkOutPage.clickContinue();

        Assert.assertTrue(
                checkOutPage.isCheckOutOverviewDisplayed(),
                "Checkout overview should be displayed.");
    }

    @When("the user completes the order")
    public void userCompletesTheOrder() {

        orderConfirmationPage = new OrderConfirmationPage(DriverFactory.getDriver());

        checkOutPage.clickFinishBtn();
    }

    @Then("the order should be confirmed")
    public void orderShouldBeConfirmed() {

        Assert.assertTrue(
                orderConfirmationPage.isOrderConfirmed(),
                "Order should be confirmed.");

        Assert.assertEquals(
                orderConfirmationPage.getConfirmationMesssege(),
                "Thank you for your order!",
                "Unexpected order confirmation message.");

        System.out.println(">>> CUCUMBER: Order confirmed");
    }
}