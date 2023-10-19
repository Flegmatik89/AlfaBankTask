package utils;

import driver.MobileDriver;
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
                MobileDriver.getInstance().getScreenshotAs(OutputType.BYTES));
    }
}
