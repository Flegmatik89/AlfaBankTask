package com.example.alfaTestTask.stepdefinitions;

import static com.example.alfaTestTask.stepdefinitions.BaseSteps.*;

import java.util.regex.Pattern;

import io.qameta.allure.Step;

public class MainWindowSteps {
    public final String VALID_CHARACTERS = "[A-Za-z\\.,/'_\\-\s]+";

    @Step("Ожидание загрузки приложения")
    public void waitLoadApp() {
        waitElementToDisplayed(20);
    }

    @Step("Получить текст заглавной надписи")
    public String getTextAlfaTitle() {
        return alfaTitle.getText();
    }

    @Step("Получить плейсхолдер поля Login")
    public String getTitleFromLoginField() {
        return loginField.getText();
    }

    @Step("Получить плейсхолдер поля Password")
    public String getTitleFromPasswordField() {
        return passField.getText();
    }

    @Step("Проверить заглавную надпись - Вход в Alfa-Test")
    public boolean checkMainTitle(String attribute) {
        return Boolean.parseBoolean(alfaTitle.getAttribute(attribute));
    }

    @Step("Снять фокус с поля Логин")
    public void clickEnterForLoginField() {
        loginField.clickEnterForRemoveFocus();
    }

    @Step("Снять фокус с поля Пароль")
    public void clickEnterForPasswordField() {
        passField.clickEnterForRemoveFocus();
    }

    @Step("Ввод логина с помощью клавиатуры")
    public void setLoginFromKeyboard(String login) {
        loginField.click();
        loginField.clearField();
        loginField.setTextFromKeyboard(login);
    }

    @Step("Ввод логина с помощью копирования/вставки")
    public void setLoginCopyPaste(String login) {
        loginField.click();
        loginField.clearField();
        loginField.takeTextToClipboardAndPaste(login);
    }

    @Step("Получить текст из поля Логин")
    public String getTextFromLoginField() {
        return loginField.getText();
    }

    @Step("Ввод пароля с помощью клавиатуры")
    public void setPasswordFromKeyboard(String pass) {
        passField.click();
        passField.clearField();
        passField.setTextFromKeyboard(pass);
    }

    @Step("Ввод пароля с помощью копирования/вставки")
    public void setPasswordCopyPaste(String pass) {
        passField.click();
        passField.clearField();
        passField.takeTextToClipboardAndPaste(pass);
    }

    @Step("Получить текст из поля Пароль")
    public String getTextFromPasswordField() {
        return passField.getText();
    }

    @Step("Нажать кнопку Показать пароль")
    public void clickShowPassword() {
        showPassButton.click();
    }

    @Step("Проверка отображения скрытия пароля")
    public String checkHidePassword() {
        return passField.getAttribute("password");
    }

    @Step("Нажать кнопку Вход")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Получить текст кнопки Войти")
    public String getNameLoginButton() {
        return loginButton.getText();
    }

    @Step("Получить текст сообщения о ошибке")
    public String getErrorMessageInvalidCredentials() {
        return errorMessageInvalidCredentials.getText();
    }

    @Step("Ожидание сообщения о неуспешном входе")
    public void waitErrorMessageInvalidCredentials() {
        waitErrorMessageToDisplayed(5);
    }

    @Step("Проверка отсутствия сообщения о ошибке")
    public boolean checkErrorMessageForField() {
        return checkErrorMessageIsNotDisplayed(5);
    }

    @Step("Проверка символов на ожидаемые требования")
    public boolean checkValidCharacters(String characters) {
        return Pattern.matches(VALID_CHARACTERS, characters);
    }
}
