package com.transmuda.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        try {

            FileInputStream file = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(file);
            file.close();

        } catch (Exception e) {

            System.out.println("File not found in the ConfigurationReader class!");
            e.printStackTrace();

        }
    }

    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }
}
