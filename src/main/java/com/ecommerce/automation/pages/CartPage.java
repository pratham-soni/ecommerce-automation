package com.ecommerce.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.automation.utils.WaitUtils;

public class CartPage {
    private final WaitUtils waitUtils;

    private final By cartTitle = By.cssSelector(".title");
    private final By backpackItem = By.id("item_4_title_link");
    private final By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver){
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isCartPageDisplayed(){
        return waitUtils.waitForVisibility(cartTitle).isDisplayed();
    }

    public boolean isBackpackDisplayed(){
        return waitUtils.waitForVisibility(backpackItem).isDisplayed();
    }

    public void clickCheckout(){
        waitUtils.waitForClickable(checkoutBtn).click();
    }
}
 