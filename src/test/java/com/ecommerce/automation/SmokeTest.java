package com.ecommerce.automation;

import com.ecommerce.automation.base.BaseTest;
import com.ecommerce.automation.driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void seleniumHomePageTitleShouldContainSelenium() throws InterruptedException {
        DriverFactory.getDriver().get("https://www.selenium.dev/");

        Assert.assertTrue(DriverFactory.getDriver().getTitle().contains("Selenium"),
        "Expected the Selenium home page title to contain 'Selenium'.");
    }
}
