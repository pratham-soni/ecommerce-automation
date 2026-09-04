package com.ecommerce.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
    private static final Properties properties = new Properties();

    static{
        try{
            FileInputStream fis = new FileInputStream("src/test/resources/config/testdata.properties");
            properties.load(fis);
            fis.close();
        } catch(IOException e){
            throw new RuntimeException("Unable to load test data properties file.", e);
        }
    }

    private TestDataReader(){
        //utility class
    }

    public static String get(String key){
        String value = properties.getProperty(key);

        if(value == null || value.isBlank()){
            throw new IllegalArgumentException(
                "Test data not found for the key : " + key
            );
        }

        return value;
    }
}
