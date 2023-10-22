package tests.loginTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class TestLoginFieldAppLoginScreen extends BaseTest {
    private static final String ERROR_MESSAGE_INVALID_LOGIN = "Логин может содержать только цифры и символы подчеркивания";
    private static final String INVALID_CHARACTERS = "[.,/'_-]  ";
    private static final String ERROR_MESSAGE_REMOVE_INVALID_SYMBOLS = "Недопустимые символы были удалены из логина";
    private static final String VALID_LOGIN = "Login-1";

    @Description("Тест поля ввода логина")
    @Test()
    @Owner("Rudenok_B")
    public void testLoginField() {
        loginScreen.waitLoadApp();
        loginScreen.inputLoginFromKeyboard("a".repeat(49));
        softly.assertThat(49).isEqualTo(loginScreen.takeTextFromLoginField().length()).as("check the number of characters");
        loginScreen.inputLoginFromKeyboard("a".repeat(50));
        softly.assertThat(50).isEqualTo(loginScreen.takeTextFromLoginField().length()).as("check the number of characters");
        loginScreen.inputLoginFromKeyboard("a".repeat(51));
        softly.assertThat(50).isEqualTo(loginScreen.takeTextFromLoginField().length()).as("check the number of characters");
        loginScreen.inputLoginFromKeyboard(INVALID_CHARACTERS);

        try {
            softly.assertThat(ERROR_MESSAGE_INVALID_LOGIN).isEqualTo(loginScreen.errorMessageInvalidLogin.getText());
        } catch (Exception e) {
            softly.fail("error message not found exception");
            utils.takeScreenshot("error message not found");
        }
        loginScreen.passField.click();
        try {
            softly.assertThat(ERROR_MESSAGE_INVALID_LOGIN).isEqualTo(loginScreen.errorMessageInvalidLogin.getText());
        } catch (Exception e) {
            softly.fail("error message not found with refocused");
            utils.takeScreenshot("error message not found with refocused");
        }
        loginScreen.pasteLogin(INVALID_CHARACTERS);
        try {
            softly.assertThat(ERROR_MESSAGE_REMOVE_INVALID_SYMBOLS).isEqualTo(loginScreen.errorMessageRemoveInvalidSymbols.getText());
        } catch (Exception e) {
            softly.fail("error message not found exception");
            utils.takeScreenshot("error message not found");
        }
        softly.assertThat("_-").isEqualTo(loginScreen.takeTextFromLoginField());
        loginScreen.inputLoginFromKeyboard(VALID_LOGIN);
        softly.assertThat(VALID_LOGIN).isEqualTo(loginScreen.takeTextFromLoginField());
        try {
            softly.assertThat(ERROR_MESSAGE_INVALID_LOGIN).isEqualTo(loginScreen.errorMessageInvalidLogin.getText());
        } catch (Exception ignored) {
        }
        softly.assertAll();
    }

}
