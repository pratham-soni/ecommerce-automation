package com.ecommerce.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(1);

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final boolean SLOW_MODE = Boolean.parseBoolean(System.getProperty("slow", "false"));

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, DEFAULT_TIMEOUT);
    }

    private void debugDelay(){
        if (SLOW_MODE){
            try{
                Thread.sleep(DEFAULT_TIMEOUT.toMillis());
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public WebElement waitForVisibility(By locator) {
        WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        debugDelay();
        return element;
    }

    public WebElement waitForClickable(By locator) {
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(locator));
        debugDelay();
        return element;
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
