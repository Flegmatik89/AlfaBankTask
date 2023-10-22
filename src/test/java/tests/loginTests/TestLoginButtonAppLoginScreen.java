package tests.loginTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class TestLoginButtonAppLoginScreen extends BaseTest {
    private static final String LOGIN_BUTTON_TEXT = "Вход";
    private static final String ERROR_MESSAGE_INVALID_CREDENTIALS = "Неверный логин или пароль";

    @Description("Тест кнопки войти")
    @Test()
    @Owner("Rudenok_B")
    public void testLoginButton() {
        loginScreen.waitLoadApp();
        softly.assertThat(LOGIN_BUTTON_TEXT).isEqualTo(loginScreen.takeNameLoginButton());
        loginScreen.selectLoginButton();
        loginScreen.waitErrorMessageInvalidCredentials();
        softly.assertThat(ERROR_MESSAGE_INVALID_CREDENTIALS).isEqualTo(loginScreen.takeErrorMessageInvalidCredentials());
        softly.assertAll();
    }
}
