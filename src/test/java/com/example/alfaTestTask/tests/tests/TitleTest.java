package com.example.alfaTestTask.tests.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import com.example.alfaTestTask.BaseTest;

public class TitleTest extends BaseTest {
    private static final String TITLE = "Вход в Alfa-Test";

    @Order(1)
    @Description("Тест на отображение заглавной надписи")
    @Test()
    public void checkDisplayTitle() {
        mainWindowSteps.waitLoadApp();
        assertTrue(mainWindowSteps.checkMainTitle("displayed"),
                "Заглавная надпись не отображается на странице");
    }

    @Order(2)
    @Description("Тест на соответствие требованиям заглавной надписи")
    @Test()
    public void checkTextTitle() {
        mainWindowSteps.waitLoadApp();
        assertEquals(TITLE, mainWindowSteps.getTextAlfaTitle() ,
                "Заглавная надпись не соответствует ожидаемой");
        assertFalse(mainWindowSteps.checkMainTitle("clickable"), "Заглавная надпись кликабельна");
    }

    @Order(3)
    @Description("Тест на взаимодействие с заглавной надписью")
    @Test()
    public void checkClickableTitle() {
        mainWindowSteps.waitLoadApp();
        assertFalse(mainWindowSteps.checkMainTitle("clickable"),
                "Заглавная надпись кликабельна");
    }
}
