package com.ecommerce.automation.base;

import com.ecommerce.automation.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser");
        if (browser == null || browser.isBlank()) {
            browser = "chrome";
        }

        DriverFactory.initializeDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
