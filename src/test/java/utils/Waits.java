package utils;

import driver.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {
    public WebElement waitForElementDisplayed(By locator, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(MobileDriver.getInstance(), timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public Boolean waitForElementDisappears(By locator, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(MobileDriver.getInstance(), timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void slip(long timeoutInSeconds) {
        MobileDriver.getInstance().manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }
}
