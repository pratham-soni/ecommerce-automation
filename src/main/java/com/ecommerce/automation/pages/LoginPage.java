package com.ecommerce.automation.pages;

import com.ecommerce.automation.utils.LocatorFactory;
import com.ecommerce.automation.utils.YamlLocatorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ecommerce.automation.utils.ConfigReader;
import com.ecommerce.automation.utils.WaitUtils;

public class LoginPage {
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By usernameInput = LocatorFactory.create(
            YamlLocatorReader.get("login", "username"));

    private final By passwordInput = LocatorFactory.create(
            YamlLocatorReader.get("login", "password"));

    private final By loginBtn = LocatorFactory.create(
            YamlLocatorReader.get("login", "loginButton"));

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void open() {
        driver.get(ConfigReader.get("baseUrl"));
    }

    public void enterUsername(String username) {
        waitUtils.waitForVisibility(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtils.waitForVisibility(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        waitUtils.waitForClickable(loginBtn).click();
    }

}
