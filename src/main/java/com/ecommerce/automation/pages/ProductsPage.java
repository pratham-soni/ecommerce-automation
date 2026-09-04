package com.ecommerce.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.automation.utils.WaitUtils;

public class ProductsPage {
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By pageTitle = By.cssSelector(".title");
    private final By cartLink = By.className("shopping_cart_link");
    private final By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void addBackPacktoCart(){
        waitUtils.waitForClickable(backpackAddToCart).click();
    }

    public boolean isProductPageDisplayed(){
        return waitUtils.waitForVisibility(pageTitle).isDisplayed();
    }

    public String getTitle(){
        return waitUtils.waitForVisibility(pageTitle).getText();
    }

    public void openCart(){
        waitUtils.waitForClickable(cartLink).click();
    }
}
