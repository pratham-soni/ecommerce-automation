package com.ecommerce.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import com.ecommerce.automation.utils.LocatorFactory;
import com.ecommerce.automation.utils.WaitUtils;
import com.ecommerce.automation.utils.YamlLocatorReader;

public class CheckOutPage {
    private final WaitUtils waitUtils;

    private final By firstNameInput = LocatorFactory.create(YamlLocatorReader.get("checkout","firstNameInput"));
    private final By lastNameInput = LocatorFactory.create(YamlLocatorReader.get("checkout","lastNameInput"));
    private final By postalCodeInput = LocatorFactory.create(YamlLocatorReader.get("checkout","postalCodeInput"));
    private final By continueBtn = LocatorFactory.create(YamlLocatorReader.get("checkout","continueBtn"));
    private final By checkOutOverview = LocatorFactory.create(YamlLocatorReader.get("checkout","checkOutOverview"));
    private final By finisBtn = LocatorFactory.create(YamlLocatorReader.get("checkout","finishButton"));
    private final By checkOutPageTitle = LocatorFactory.create(YamlLocatorReader.get("checkout","checkOutPageTitle"));

    public CheckOutPage(WebDriver driver){
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isCheckOutPageDisplayed(){
        return waitUtils.waitForVisibility(checkOutPageTitle).isDisplayed();
    }

    public void enterFirstName(String firstName){
        waitUtils.waitForVisibility(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        waitUtils.waitForVisibility(lastNameInput).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        waitUtils.waitForVisibility(postalCodeInput).sendKeys(postalCode);
    }

    public void clickContinue(){
        waitUtils.waitForClickable(continueBtn).click();
    }

    public boolean isCheckOutOverviewDisplayed(){
        return waitUtils.waitForPresence(checkOutOverview).isDisplayed();
    }

    public void clickFinishBtn(){
        waitUtils.waitForClickable(finisBtn).click();
    }
}
