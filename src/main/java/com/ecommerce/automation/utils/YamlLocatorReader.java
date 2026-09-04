package com.ecommerce.automation.utils;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public final class YamlLocatorReader {

    private static final Map<String, Object> LOCATORS;

    static {
        try {
            Yaml yaml = new Yaml();

            InputStream inputStream =
                    YamlLocatorReader.class
                            .getClassLoader()
                            .getResourceAsStream("locators/saucedemo.yml");

            if (inputStream == null) {
                throw new RuntimeException(
                        "Unable to find locators/saucedemo.yml"
                );
            }

            LOCATORS = yaml.load(inputStream);

            inputStream.close();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Unable to load saucedemo.yml", e
            );
        }
    }

    private YamlLocatorReader() {
        // Utility class
    }

    public static String get(String page, String element) {

        Object pageObject = LOCATORS.get(page);

        if (!(pageObject instanceof Map)) {
            throw new IllegalArgumentException(
                    "Page not found in locator file: " + page
            );
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> pageLocators =
                (Map<String, Object>) pageObject;

        Object locator = pageLocators.get(element);

        if (locator == null) {
            throw new IllegalArgumentException(
                    "Locator not found for: " + page + "." + element
            );
        }

        return locator.toString();
    }
}