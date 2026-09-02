package com.ecommerce.automation.pages;

import org.openqa.selenium.WebDriver;

public class SeleniumHomePage {

    private static final String PAGE_URL = "https://www.selenium.dev/";

    private final WebDriver driver;

    public SeleniumHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isPageDisplayed() {
        return getPageTitle().contains("Selenium");
    }
}
