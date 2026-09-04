package com.ecommerce.automation.driver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

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
     * @throws IllegalStateException    if this thread already has an active driver
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
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();

                Map<String, Object> preferences = new HashMap<>();
                preferences.put("credentials_enable_service", false);
                preferences.put("profile.password_manager_enabled", false);
                preferences.put("profile.password_manager_leak_detection", false);

                options.setExperimentalOption("prefs", preferences);

                yield new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser + ". Currently supported: chrome.");
        };

        webDriver.manage().window().maximize();

        EventFiringDecorator<WebDriver> decorator =
        new EventFiringDecorator<>(new HighlightingListener(webDriver));

DRIVER.set(decorator.decorate(webDriver));
    }

    /**
     * Returns the WebDriver associated with the current thread.
     *
     * @return the active WebDriver
     * @throws IllegalStateException if no driver has been initialized for this
     *                               thread
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

    private static final class HighlightingListener implements WebDriverListener {

    private final JavascriptExecutor javascriptExecutor;

    private HighlightingListener(WebDriver driver) {
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Override
    public void beforeAnyWebElementCall(
            WebElement element, Method method, Object[] args) {
        try {
            javascriptExecutor.executeScript(
                    "arguments[0].style.outline='3px solid #facc15';"
                            + "arguments[0].style.outlineOffset='2px';",
                    element);
        } catch (WebDriverException ignored) {
            // Highlighting is visual-only and must not fail the test.
        }
    }
}
}
