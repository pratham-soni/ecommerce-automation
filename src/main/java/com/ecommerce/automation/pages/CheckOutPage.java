package com.ecommerce.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import com.ecommerce.automation.utils.WaitUtils;

public class CheckOutPage {
    private final WaitUtils waitUtils;

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By checkOutOverview = By.xpath("//span[contains(text(),'Checkout: Overview')]");
    private final By finisBtn = By.id("finish");
    private final By checkOutPageTitle = By.xpath("//span[contains(text(),'Checkout: Your Information')]");

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
