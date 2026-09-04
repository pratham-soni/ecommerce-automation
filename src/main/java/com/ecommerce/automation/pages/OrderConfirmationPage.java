package com.ecommerce.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.automation.utils.WaitUtils;

public class OrderConfirmationPage {
    private final WaitUtils waitUtils;

    private final By completeMessege = By.className("complete-header");

    public OrderConfirmationPage(WebDriver driver){
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isOrderConfirmed(){
        return waitUtils.waitForVisibility(completeMessege).isDisplayed();
    }

    public String getConfirmationMesssege(){
        return waitUtils.waitForPresence(completeMessege).getText();
    }
}
