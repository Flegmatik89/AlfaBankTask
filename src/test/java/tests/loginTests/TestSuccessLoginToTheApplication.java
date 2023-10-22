package tests.loginTests;

import enums.UsersCredentials;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class TestSuccessLoginToTheApplication extends BaseTest {
    private static final String LOGIN_SUCCESS_MESSAGE = "Вход в Alfa-Test выполнен";

    @Description("Тест корректного входа в приложение")
    @Test()
    @Owner("Rudenok_B")
    public void testSuccessLoginToTheApplication() {
        loginScreen.waitLoadApp();
        loginScreen.inputLoginFromKeyboard(UsersCredentials.LOGIN.getCreeds());
        loginScreen.inputPassFromKeyboard(UsersCredentials.PASS.getCreeds());
        loginScreen.selectLoginButton();
        loginSuccessScreen.waitSuccessMessage();
        softly.assertThat(LOGIN_SUCCESS_MESSAGE).isEqualTo(loginSuccessScreen.takeSuccessMessage());
        softly.assertAll();
    }
}
