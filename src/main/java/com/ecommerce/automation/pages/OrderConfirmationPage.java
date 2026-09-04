package com.ecommerce.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.automation.utils.LocatorFactory;
import com.ecommerce.automation.utils.WaitUtils;
import com.ecommerce.automation.utils.YamlLocatorReader;

public class OrderConfirmationPage {
    private final WaitUtils waitUtils;

    private final By completeMessege = LocatorFactory.create(YamlLocatorReader.get("orderConfirmation","confirmationMessage"));

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
