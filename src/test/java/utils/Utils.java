package utils;

import driver.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

public class Utils {
    private static final String TYPE = "image/png";
    private static final String FILE_EXTENSION = "png";

    /**
     * Метод для создания скриншота и отправка его в allure
     *
     * @param nameScreen Название скриншота
     */
    public void takeScreenshot(String nameScreen) {
        Allure.getLifecycle().addAttachment(nameScreen,
                TYPE,
                FILE_EXTENSION,
                MobileDriver.getMobileDriver().getScreenshotAs(OutputType.BYTES));
    }

    /**
     * Метод для для вставки текста из буфера обмена
     *
     * @param text текст для втавки
     */
    public void takeTextToClipboardAndPaste(String text) {
        ((AndroidDriver) MobileDriver.getMobileDriver()).setClipboardText(text);
        ((AndroidDriver) MobileDriver.getMobileDriver()).pressKey(new KeyEvent(AndroidKey.PASTE));
    }
}
