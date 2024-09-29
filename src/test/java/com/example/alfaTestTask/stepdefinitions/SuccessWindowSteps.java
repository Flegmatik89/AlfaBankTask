package com.example.alfaTestTask.stepdefinitions;

import static com.example.alfaTestTask.stepdefinitions.BaseSteps.loginSuccessMessage;
import static com.example.alfaTestTask.stepdefinitions.BaseSteps.waitSuccessMessageToDisplayed;

import io.qameta.allure.Step;

public class SuccessWindowSteps {

    @Step("Ожидание получения сообщения о успешном входе")
    public void waitSuccessMessage() {
        waitSuccessMessageToDisplayed(5);
    }

    @Step("Получить текст сообщения о успешном входе")
    public String takeSuccessMessage() {
        return loginSuccessMessage.getText();
    }
}
