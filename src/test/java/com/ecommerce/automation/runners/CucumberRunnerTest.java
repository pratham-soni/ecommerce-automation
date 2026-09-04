package com.ecommerce.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "com.ecommerce.automation.stepdefinitions",
                "com.ecommerce.automation.hooks"
        },
        plugin = {"pretty"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}