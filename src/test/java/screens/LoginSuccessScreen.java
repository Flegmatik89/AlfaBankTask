package screens;

import elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginSuccessScreen extends BaseScreen {
    private static final String LOGIN_SUCCESS_MESSAGE = "//*[@text = 'Вход в Alfa-Test выполнен']";

    public Button loginSuccessMessage = new Button(By.xpath(LOGIN_SUCCESS_MESSAGE), "login Success Message");

    @Step("wait success message")
    public void waitSuccessMessage() {
        waits.waitForElementDisplayed(By.xpath(LOGIN_SUCCESS_MESSAGE), "login failed", 20);
    }

    @Step("take success message")
    public String takeSuccessMessage() {
        return loginSuccessMessage.getText();
    }
}
