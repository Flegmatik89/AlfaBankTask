package com.example.alfaTestTask.tests.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import com.example.alfaTestTask.BaseTest;
import com.example.alfaTestTask.enums.UsersCredentials;

public class LoginButtonTest extends BaseTest {
    private static final String LOGIN_BUTTON_TEXT = "Вход";
    private static final String ERROR_MESSAGE_INVALID_CREDENTIALS = "Введены неверные данные";
    private static final String LOGIN_SUCCESS_MESSAGE = "Вход в Alfa-Test выполнен";

    @Order(1)
    @Description("Тест названия кнопки Войти")
    @Test
    public void checkNameButton() {
        mainWindowSteps.waitLoadApp();
        assertEquals(LOGIN_BUTTON_TEXT, mainWindowSteps.getNameLoginButton(),
                "Название кнопки не соответствует ожидаемой");
        utils.takeScreenshot();
    }

    @Order(2)
    @Description("Тест успешного входа в приложение")
    @Test()
    public void checkSuccessLoginToTheApplication() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard(UsersCredentials.LOGIN.getCredential());
        mainWindowSteps.setPasswordFromKeyboard(UsersCredentials.PASS.getCredential());
        mainWindowSteps.clickLoginButton();
        successWindowSteps.waitSuccessMessage();
        assertEquals(LOGIN_SUCCESS_MESSAGE, successWindowSteps.takeSuccessMessage(),
                "Сообщение о успешном входе не соответствует");
        utils.takeScreenshot();
    }

    @Order(3)
    @Description("Тест входа в приложение с неверным логином")
    @Test()
    public void checkInvalidLoginToTheApplication() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard(ENTERED_VALUE_VALID);
        mainWindowSteps.setPasswordFromKeyboard(UsersCredentials.PASS.getCredential());
        mainWindowSteps.clickLoginButton();
        mainWindowSteps.waitErrorMessageInvalidCredentials();
        assertEquals(ERROR_MESSAGE_INVALID_CREDENTIALS, mainWindowSteps.getErrorMessageInvalidCredentials(),
                "Сообщение о ошибке не отображается");
        utils.takeScreenshot();
    }

    @Order(4)
    @Description("Тест входа в приложение с неверным паролем")
    @Test()
    public void checkInvalidPasswordToTheApplication() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard(UsersCredentials.LOGIN.getCredential());
        mainWindowSteps.setPasswordFromKeyboard(ENTERED_VALUE_VALID);
        mainWindowSteps.clickLoginButton();
        mainWindowSteps.waitErrorMessageInvalidCredentials();
        assertEquals(ERROR_MESSAGE_INVALID_CREDENTIALS, mainWindowSteps.getErrorMessageInvalidCredentials(),
                "Сообщение о ошибке не отображается");
        utils.takeScreenshot();
    }

    @Order(5)
    @Description("Тест кнопки войти")
    @Test()
    public void checkEmptyFieldsToTheApplication() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.clickLoginButton();
        mainWindowSteps.waitErrorMessageInvalidCredentials();
        assertEquals(ERROR_MESSAGE_INVALID_CREDENTIALS, mainWindowSteps.getErrorMessageInvalidCredentials(),
                "Описание ошибки входа с пустыми полями не соответствует ожидаемому результату");
        utils.takeScreenshot();
    }
}
