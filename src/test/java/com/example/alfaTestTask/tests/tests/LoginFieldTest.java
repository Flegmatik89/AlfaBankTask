package com.example.alfaTestTask.tests.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import com.example.alfaTestTask.BaseTest;

public class LoginFieldTest extends BaseTest {
    public static final String LABEL_LOGIN_FIELD = "Логин";
    public static final String ENTERED_VALUE_INVALID = "*%^() \"<>\\|&^#@";

    @Order(1)
    @Description("Проверка лейбл (плейсхолдер) поля Логин")
    @Test
    public void checkLabelInLoginField() {
        mainWindowSteps.waitLoadApp();
        assertEquals(LABEL_LOGIN_FIELD, mainWindowSteps.getTitleFromLoginField(),
                "Лейбл в поле Логина не соответствует ожидаемому");
        utils.takeScreenshot();
    }

    @Order(2)
    @Description("Проверка неразрешенных символов для поля Логин")
    @Test
    public void checkInvalidCharactersInLoginField() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard(ENTERED_VALUE_INVALID);
        assertTrue(mainWindowSteps.checkValidCharacters(ENTERED_VALUE_INVALID),
                "Введены невалидные значения");
        utils.takeScreenshot();
    }

    @Order(3)
    @Description("Проверка разрешенных символов для поля Логин")
    @Test
    public void checkCharactersInLoginField() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard(ENTERED_VALUE_VALID);
        assertTrue(mainWindowSteps.checkValidCharacters(ENTERED_VALUE_VALID),
                "Введены невалидные значения");
        utils.takeScreenshot();
    }

    @Order(4)
    @Description("Проверка сообщения о ошибке при вводе невалидных символов в поле Логин")
    @Test
    public void checkErrorMessageForLoginField() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard(ENTERED_VALUE_INVALID);
        mainWindowSteps.clickEnterForLoginField();
        assertFalse(mainWindowSteps.checkErrorMessageForField(),
                "Сообщение о ошибке не отображается");
        utils.takeScreenshot();
    }

    @Order(5)
    @Description("Проверка на количество ввода символов (граничное значение 49)")
    @Test
    public void checkFortyNineEnteredCountCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard("i".repeat(49));
        mainWindowSteps.clickEnterForLoginField();
        assertTrue(mainWindowSteps.checkErrorMessageForField(),
                "Сообщение о ошибке отображается");
        utils.takeScreenshot();
    }

    @Order(6)
    @Description("Проверка на количество ввода символов (граничное значение 50)")
    @Test
    public void checkFifteenEnteredCountCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard("i".repeat(50));
        mainWindowSteps.clickEnterForLoginField();
        assertTrue(mainWindowSteps.checkErrorMessageForField(),
                "Сообщение о ошибке отображается");
        utils.takeScreenshot();
    }

    @Order(7)
    @Description("Проверка на количество ввода символов (граничное значение 51)")
    @Test
    public void checkFiftyOneEnteredCountCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginFromKeyboard("i".repeat(51));
        mainWindowSteps.clickEnterForLoginField();
        assertFalse(mainWindowSteps.checkErrorMessageForField(),
                "Сообщение о ошибке не отображается");
        utils.takeScreenshot();
    }

    @Order(8)
    @Description("Проверка копирования и вставки логина в поле (граничное значение 51)")
    @Test
    public void checkFiftyOneCopyPasteCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginCopyPaste(FIFTY_ONE_CHARACTERS);
        mainWindowSteps.clickEnterForLoginField();
        assertEquals(50, mainWindowSteps.getTextFromLoginField().length(),
                "Символы не обрезаны по длине");
        utils.takeScreenshot();
    }

    @Order(9)
    @Description("Проверка копирования и вставки логина в поле (невалидные символы)")
    @Test
    public void checkCopyPasteInvalidCharacters() {
        mainWindowSteps.waitLoadApp();
        mainWindowSteps.setLoginCopyPaste(INVALID_AND_VALID_CHARACTERS);
        mainWindowSteps.clickEnterForLoginField();
        assertTrue(mainWindowSteps.checkValidCharacters(mainWindowSteps.getTextFromLoginField()),
                "Невалидные символы не обрезаны");
        utils.takeScreenshot();
    }
}
