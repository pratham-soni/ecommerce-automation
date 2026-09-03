package com.ecommerce.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ecommerce.automation.utils.WaitUtils;

public class LoginPage {
    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("login-button");


    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void open(){
        driver.get(PAGE_URL);
    }

    public void enterUsername(String username){
        waitUtils.waitForVisibility(usernameInput).sendKeys(username);
    }

    public void enterPassword (String password){
        waitUtils.waitForVisibility(passwordInput).sendKeys(password);
    }

    public void clickLogin(){
        waitUtils.waitForClickable(loginBtn).click();
    }

}
