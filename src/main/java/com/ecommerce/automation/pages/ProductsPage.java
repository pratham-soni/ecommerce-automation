package com.ecommerce.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.automation.utils.WaitUtils;

public class ProductsPage {
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By pageTitle = By.cssSelector(".title");
    private final By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
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
