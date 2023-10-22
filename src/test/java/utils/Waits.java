package utils;

import driver.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Waits {
    /**
     * Метод ожидания появления элемента
     *
     * @param locator          локатор элемента
     * @param error_message    сообщение об ошибке
     * @param timeoutInSeconds кол-во сек. ожидания
     */
    public WebElement waitForElementDisplayed(By locator, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(MobileDriver.getMobileDriver(), timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Метод ожидания исчезновения элемента
     *
     * @param locator          локатор элемента
     * @param error_message    сообщение об ошибке
     * @param timeoutInSeconds кол-во сек. ожидания
     */
    public Boolean waitForElementDisappears(By locator, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(MobileDriver.getMobileDriver(), timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void slip(long timeoutInSeconds) {
        MobileDriver.getMobileDriver().manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }
}
