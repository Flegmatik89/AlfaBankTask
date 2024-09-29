package com.example.alfaTestTask.utility;

import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

import lombok.SneakyThrows;

public class ConfigurationManager {
    private static final String PATH_CONF = "src/test/resources/configuration.properties";
    private static final String PATH_CONF_IOS = "src/test/resources/IosConfiguration.properties";
    private static final String PATH_CONF_ANDROID = "src/test/resources/androidConfiguration.properties";
    private static final String PATH_TEST_DATA = "src/test/resources/credentials.properties";
    public static final String NAME_DRIVER = "NameDriver";
    public static final String IOS = "IOS";
    public static final String ANDROID = "ANDROID";

    @SneakyThrows
    private static Properties readPropertyFromConfFile(String path) {
        FileReader fileInputStreamConf = new FileReader(path);
        Properties properties = new Properties();
        properties.load(fileInputStreamConf);
        return properties;
    }

    public static String identifyPlatformForGetProperty(String key) {
        if(ANDROID.equals(readPropertyFromConfFile(PATH_CONF).getProperty(NAME_DRIVER))) {
            return readPropertyFromConfFile(PATH_CONF_ANDROID).getProperty(key);
        } else if (IOS.equals(readPropertyFromConfFile(PATH_CONF).getProperty(NAME_DRIVER))) {
            return readPropertyFromConfFile(PATH_CONF_IOS).getProperty(key);
        }
        return "error read properties";
    }

    public static String getPropertyFromConfigurationFile(String key) {
        return readPropertyFromConfFile(PATH_CONF).getProperty(key);
    }

    public static String getPropertyFromTestDataFile(String key) {
        return readPropertyFromConfFile(PATH_TEST_DATA).getProperty(key);
    }

    public static Set<String> getAllPropertiesFromFile() {
        return readPropertyFromConfFile(PATH_CONF).stringPropertyNames();
    }

}
