package com.ecommerce.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.automation.utils.LocatorFactory;
import com.ecommerce.automation.utils.WaitUtils;
import com.ecommerce.automation.utils.YamlLocatorReader;

public class ProductsPage {
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By pageTitle = LocatorFactory.create(YamlLocatorReader.get("products", "pageTitle"));
    private final By cartLink = LocatorFactory.create(YamlLocatorReader.get("products","cartLink"));
    private final By backpackAddToCart = LocatorFactory.create(YamlLocatorReader.get("products","backpackAddToCart"));

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
