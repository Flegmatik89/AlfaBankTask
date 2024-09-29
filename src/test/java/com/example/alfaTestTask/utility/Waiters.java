package com.example.alfaTestTask.utility;

import com.example.alfaTestTask.driver.EmulatorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;


public class Waiters {
    /**
     * Метод ожидания появления элемента
     */
    public WebElement waitForElementDisplayed(By locator, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(EmulatorDriver.getMobileDriver(), timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Метод ожидания исчезновения элемента
     */
    public Boolean waitForElementDisappears(By locator, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(EmulatorDriver.getMobileDriver(), timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Метод ожидания по заданному количеству времени
     */
    @SneakyThrows
    public void sleep(long timeoutInSeconds) {
        Thread.sleep(10_000);
        //EmulatorDriver.getMobileDriver().manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }
}
