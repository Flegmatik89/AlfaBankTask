package com.example.alfaTestTask.stepdefinitions;

import com.example.alfaTestTask.components.ComponentsConstants;
import com.example.alfaTestTask.driver.EmulatorDriver;
import com.example.alfaTestTask.utility.Waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lombok.Getter;

@Getter
public class BaseSteps extends Waiters implements ComponentsConstants {
    protected static Waiters waiters = new Waiters();
    protected final By locator;

    public BaseSteps(By locator, String description) {
        this.locator = locator;
    }

    public static final BaseSteps alfaTitle = new BaseSteps(By.xpath(ALFA_TITLE),
            "Заглавная надпись");
    public static final BaseSteps loginField = new BaseSteps(By.id(LOGIN_FIELD),
            "Поле ввода логина");
    public static final BaseSteps passField = new BaseSteps(By.xpath(PASS_FIELD),
            "Поле ввода пароля");
    public static final BaseSteps loginSuccessMessage = new BaseSteps(By.xpath(LOGIN_SUCCESS_MESSAGE),
            "Сообщение о успешном входе");
    public static final BaseSteps loginButton = new BaseSteps(By.xpath(LOGIN_BUTTON),
            "Кнопка Вход");
    public static final BaseSteps showPassButton = new BaseSteps(By.xpath(SHOW_PASS),
            "Кнопка показать пароль");
    public static final BaseSteps errorMessageInvalidCredentials =
            new BaseSteps(By.xpath(ERROR_MESSAGE_INVALID_CREDENTIALS), "Сообщение о ошибке");


    public WebElement getElement() {
        return EmulatorDriver.getMobileDriver().findElement(this.locator);
    }

    public void click() {
        this.getElement().click();
    }

    public String getText() {
        return this.getElement().getText();
    }

    public void clearField() {
        this.getElement().clear();
    }

    public void clickEnterForRemoveFocus() {
        ((AndroidDriver) EmulatorDriver.getMobileDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public String getAttribute(String attribute) {
        return this.getElement().getAttribute(attribute);
    }

    public void setTextFromKeyboard(String text) {
        EmulatorDriver.getMobileDriver().getKeyboard().pressKey(text);
    }

    public void takeTextToClipboardAndPaste(String text) {
        ((AndroidDriver) EmulatorDriver.getMobileDriver()).setClipboardText(text);
        ((AndroidDriver) EmulatorDriver.getMobileDriver()).pressKey(new KeyEvent(AndroidKey.PASTE));
    }

    public static void waitElementToDisplayed(long timeoutInSeconds) {
        waiters.waitForElementDisplayed(By.xpath(ALFA_TITLE),
                "Приложение упало", timeoutInSeconds);
    }

    public static void waitErrorMessageToDisplayed(long timeoutInSeconds) {
        waiters.sleep(timeoutInSeconds);
    }

    public static void waitSuccessMessageToDisplayed(long timeoutInSeconds) {
        waiters.waitForElementDisplayed(By.xpath(LOGIN_SUCCESS_MESSAGE),
                "Сообщение о успешном входе не отображается", timeoutInSeconds);
    }

    public static boolean checkErrorMessageIsNotDisplayed(long timeoutInSeconds) {
        return waiters.waitForElementDisappears(By.xpath(ERROR_MESSAGE_INVALID_CREDENTIALS),
                "сообщение о ошибке", timeoutInSeconds);
    }
}
