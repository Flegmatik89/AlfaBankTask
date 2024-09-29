package com.example.alfaTestTask.driver;


import com.example.alfaTestTask.utility.ConfigurationManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EmulatorDriver {
    private static AppiumDriver<?> instance;
    public static final String BASE_URL = "remoteUrl";
    public static final String NAME_DRIVER = "NameDriver";
    public static final String IOS = "IOS";
    public static final String ANDROID = "ANDROID";
    public static final long IMPLICITLY_WAIT_SEC = 5;
    private static final String PATH_TO_APP = "./src/test/resources/application/alfa-test-app.apk";
    private static final String APP_PACKAGE = ConfigurationManager.identifyPlatformForGetProperty("appPackage");


    private static DesiredCapabilities setupDriver(Set<String> properties) {
        DesiredCapabilities driverCapabilities = new DesiredCapabilities();
        for (String property : properties) {
            driverCapabilities.setCapability(property, ConfigurationManager.identifyPlatformForGetProperty(property));
        }
        return driverCapabilities;
    }

    private EmulatorDriver() {
    }

    private static String getAbsolutePath() {
        return new File(EmulatorDriver.PATH_TO_APP).getAbsolutePath();
    }

    public static AppiumDriver<?> getMobileDriver() {
        if (instance == null) {
            synchronized (EmulatorDriver.class) {
                if (instance == null) {
                    instance = getDriver();
                }
            }
        }
        return instance;
    }


    private static AppiumDriver<?> getDriver() {
        try {
            if (instance == null) {
                DesiredCapabilities capabilities;
                Set<String> driverProperty = ConfigurationManager.getAllPropertiesFromFile();
                switch (ConfigurationManager.getPropertyFromConfigurationFile(NAME_DRIVER)) {
                    case IOS:
                        capabilities = setupDriver(driverProperty);
                        instance = new IOSDriver(new URL(ConfigurationManager.getPropertyFromConfigurationFile(BASE_URL)), capabilities);
                        instance.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SEC, TimeUnit.SECONDS);
                        break;
                    case ANDROID:
                        capabilities = setupDriver(driverProperty);
                        capabilities.setCapability(MobileCapabilityType.APP, getAbsolutePath());
                        instance = new AndroidDriver(new URL(ConfigurationManager.getPropertyFromConfigurationFile(BASE_URL)), capabilities);
                        instance.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SEC, TimeUnit.SECONDS);
                        break;
                    default:
                        throw logBrowserNotSupported();
                }
            }
        } catch (Exception e) {
            System.out.println("driver setup error, in class" + EmulatorDriver.class.getSimpleName() + e);
        }
        return instance;
    }

    public static void clearApp() {
        getDriver().closeApp();
        getDriver().removeApp(APP_PACKAGE);
    }

    public static void setUpApp() {
        if (!getDriver().isAppInstalled(APP_PACKAGE)) {
            getDriver().installApp(getAbsolutePath());
            getDriver().activateApp(APP_PACKAGE);
        }
    }

    public static void startApp() {
        getDriver().activateApp(APP_PACKAGE);
    }

    @NotNull
    private static WebDriverException logBrowserNotSupported() {
        WebDriverException ex = new WebDriverException("driver is not supported");
        System.out.println(ex.getMessage() + " " + ex.getCause());
        return ex;
    }
}
