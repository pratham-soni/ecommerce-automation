package com.ecommerce.automation.hooks;

import com.ecommerce.automation.driver.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.initializeDriver(browser);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}