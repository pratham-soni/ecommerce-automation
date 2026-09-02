package com.ecommerce.automation.driver;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Creates and manages the WebDriver instance for the current test thread.
 */
public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
        // Utility class
    }

    /**
     * Creates a browser driver for the current thread.
     *
     * @param browser browser name; currently only Chrome is supported
     * @throws IllegalStateException if this thread already has an active driver
     * @throws IllegalArgumentException if the browser is unsupported
     */
    public static void initializeDriver(String browser) {
        if (DRIVER.get() != null) {
            throw new IllegalStateException("A WebDriver is already active for this thread.");
        }

        if (browser == null || browser.isBlank()) {
            throw new IllegalArgumentException("Browser name must not be blank.");
        }

        WebDriver webDriver = switch (browser.trim().toLowerCase(Locale.ROOT)) {
            case "chrome" -> new ChromeDriver();
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser + ". Currently supported: chrome.");
        };

        DRIVER.set(webDriver);
    }

    /**
     * Returns the WebDriver associated with the current thread.
     *
     * @return the active WebDriver
     * @throws IllegalStateException if no driver has been initialized for this thread
     */
    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("No WebDriver has been initialized for this thread.");
        }
        return driver;
    }

    /**
     * Quits and removes the WebDriver associated with the current thread.
     */
    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DRIVER.remove();
        }
    }
}
