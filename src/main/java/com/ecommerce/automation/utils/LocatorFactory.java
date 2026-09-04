package com.ecommerce.automation.utils;

import org.openqa.selenium.By;

public class LocatorFactory {

    private LocatorFactory(){
        //utility class
    }

    public static By create(String locator){
        if (locator == null || locator.isBlank()){
            throw new IllegalArgumentException(
                "locator must not be null or blank."
            );
        }

        String [] parts = locator.split("=",2);

        if (parts.length != 2){
            throw new IllegalArgumentException(
                "Invalid locator formate: "+ locator + ". Expected formate: type=value"
            );
        }

        String type = parts[0].trim().toLowerCase();
        String value = parts[1].trim();

        return switch (type) {
            case ("id") -> By.id(value);
            case ("xpath") -> By.xpath(value);
            case ("css") -> By.cssSelector(value);
            case ("class") -> By.className(value);
            case ("name") -> By.name(value);

            default -> throw new IllegalArgumentException(
                "Unsupported locator type: " + type
            );
        };
    } 
    
}
