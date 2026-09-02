package com.ecommerce.automation;

import com.ecommerce.automation.base.BaseTest;
import com.ecommerce.automation.driver.DriverFactory;
import com.ecommerce.automation.pages.SeleniumHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void seleniumHomePageTitleShouldContainSelenium() {
        SeleniumHomePage seleniumHomePage = new SeleniumHomePage(DriverFactory.getDriver());
        seleniumHomePage.open();

        Assert.assertTrue(seleniumHomePage.isPageDisplayed(),
                "Expected the Selenium home page to be displayed.");
    }
}
