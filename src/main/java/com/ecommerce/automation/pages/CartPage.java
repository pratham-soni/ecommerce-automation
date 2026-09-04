package com.ecommerce.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.automation.utils.LocatorFactory;
import com.ecommerce.automation.utils.WaitUtils;
import com.ecommerce.automation.utils.YamlLocatorReader;

public class CartPage {
    private final WaitUtils waitUtils;

    private final By cartTitle = LocatorFactory.create(YamlLocatorReader.get("cart","cartTitle"));
    private final By backpackItem = LocatorFactory.create(YamlLocatorReader.get("cart","backpackItem"));
    private final By checkoutBtn = LocatorFactory.create(YamlLocatorReader.get("cart","checkoutBtn"));

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
 