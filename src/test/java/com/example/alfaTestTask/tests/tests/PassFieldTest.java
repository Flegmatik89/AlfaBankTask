package com.example.alfaTestTask.tests.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import com.example.alfaTestTask.BaseTest;

public class PassFieldTest extends BaseTest {
    public static final String LABEL_PASSWORD_FIELD = "Пароль";
    public static final String ENTERED_PASS_VALUE_INVALID = " df \"<>\\|&^#@";
    private static final String INVALID_PASS = "   aa     ";
    private static final String VALID_PASS = "Pass-1";
    private static final String ERROR_MESSAGE_PASS_CANNOT_CONTAIN_SPACES = "Пароль не может содержать пробелы";
    private static final String ERROR_MESSAGE_PASS_SPACES_REMOVED = "Пробелы были удалены из пароля";

    @Order(1)
    @Description("Проверка лейбл (плейсхолдер) поля Пароль")
    @Test
    public void checkLabelInPasswordField() {
        mainWindowSteps.waitLoadApp();
        assertEquals(LABEL_PASSWORD_FIELD, mainWindowSteps.getTitleFromPasswordField(),
                "Лейбл в поле Пароля не соответствует ожидаемому");
        utils.takeScreenshot();
    }

    @Order(2)
    @Description("Проверка разрешенных символов для поля Пароль")
    @Test
    public void checkCharactersInPasswordField() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordFromKeyboard(ENTERED_VALUE_VALID);
        mainWindowSteps.clickEnterForPasswordField();
        assertTrue(mainWindowSteps.checkValidCharacters(ENTERED_VALUE_VALID),
                "Введены невалидные значения");
        utils.takeScreenshot();
    }

    @Order(3)
    @Description("Проверка неразрешенных символов для поля Пароль")
    @Test
    public void checkInvalidCharactersInPasswordField() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordFromKeyboard(ENTERED_PASS_VALUE_INVALID);
        mainWindowSteps.clickEnterForPasswordField();
        assertTrue(mainWindowSteps.checkValidCharacters(ENTERED_PASS_VALUE_INVALID),
                "Введены невалидные значения");
        utils.takeScreenshot();
    }

    @Order(4)
    @Description("Проверка сообщения о ошибке при вводе невалидных символов в поле Пароль")
    @Test
    public void checkErrorMessageForPasswordField() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard(ENTERED_PASS_VALUE_INVALID);
        mainWindowSteps.clickEnterForPasswordField();
        assertFalse(mainWindowSteps.checkErrorMessageForField(),
                "Сообщение о ошибке не отображается");
        utils.takeScreenshot();
    }

    @Order(5)
    @Description("Проверка на количество ввода символов (граничное значение 49)")
    @Test
    public void checkFortyNineEnteredCountCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordFromKeyboard("p".repeat(49));
        mainWindowSteps.clickEnterForPasswordField();
        assertTrue(mainWindowSteps.checkErrorMessageForField(),
                "Сообщение о ошибке отображается");
        utils.takeScreenshot();
    }

    @Order(6)
    @Description("Проверка на количество ввода символов (граничное значение 50)")
    @Test
    public void checkFifteenEnteredCountCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordFromKeyboard("p".repeat(50));
        mainWindowSteps.clickEnterForPasswordField();
        assertTrue(mainWindowSteps.checkErrorMessageForField(),
                "Сообщение о ошибке отображается");
        utils.takeScreenshot();
    }

    @Order(7)
    @Description("Проверка на количество ввода символов (граничное значение 51)")
    @Test
    public void checkFiftyOneEnteredCountCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordFromKeyboard("p".repeat(51));
        mainWindowSteps.clickEnterForPasswordField();
        assertFalse(mainWindowSteps.checkErrorMessageForField(),
                "Сообщение о ошибке не отображается");
        utils.takeScreenshot();
    }

    @Order(8)
    @Description("Проверка копирования и вставки пароля (граничное значение 51)")
    @Test
    public void checkFiftyOneCopyPasteCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordCopyPaste(FIFTY_ONE_CHARACTERS);
        mainWindowSteps.clickEnterForPasswordField();
        assertEquals(50, mainWindowSteps.getTextFromPasswordField().length(),
                "Символы не обрезаны по длине");
        utils.takeScreenshot();
    }

    @Order(9)
    @Description("Проверка копирования и вставки пароля в поле (невалидные символы)")
    @Test
    public void checkCopyPasteInvalidCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordCopyPaste(INVALID_AND_VALID_CHARACTERS);
        mainWindowSteps.clickEnterForPasswordField();
        assertTrue(mainWindowSteps.checkValidCharacters(mainWindowSteps.getTextFromPasswordField()),
                "Невалидные символы не обрезаны");
        utils.takeScreenshot();
    }

    @Order(10)
    @Description("Проверка отображения пароля по нажатию кнопки Показать пароль")
    @Test
    public void checkVisiblePassword() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordFromKeyboard(ENTERED_VALUE_VALID);
        mainWindowSteps.clickShowPassword();
        assertFalse(Boolean.parseBoolean(mainWindowSteps.checkHidePassword()),
                "пароль скрыт и отображается символами *");
        utils.takeScreenshot();
    }

    @Order(11)
    @Description("Проверка скрытия пароля после ввода")
    @Test
    public void checkUnVisiblePassword() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setPasswordFromKeyboard(ENTERED_VALUE_VALID);
        assertTrue(Boolean.parseBoolean(mainWindowSteps.checkHidePassword()),
                "пароль скрыт и отображается символами *");
        utils.takeScreenshot();
    }
}
