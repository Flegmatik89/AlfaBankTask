package com.example.alfaTestTask.utility;

import com.example.alfaTestTask.driver.EmulatorDriver;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Allure;

public class Utils {
    private static final String TYPE = "image/png";
    private static final String FILE_EXTENSION = "png";

    public void takeScreenshot() {
        Allure.getLifecycle().addAttachment("screen_" + System.currentTimeMillis(),
                TYPE,
                FILE_EXTENSION,
                EmulatorDriver.getMobileDriver().getScreenshotAs(OutputType.BYTES));
    }


}
