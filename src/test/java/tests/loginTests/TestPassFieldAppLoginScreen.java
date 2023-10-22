package tests.loginTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class TestPassFieldAppLoginScreen extends BaseTest {
    private static final String INVALID_PASS = "   aa     ";
    private static final String VALID_PASS = "Pass-1";
    private static final String ERROR_MESSAGE_PASS_CANNOT_CONTAIN_SPACES = "Пароль не может содержать пробелы";
    private static final String ERROR_MESSAGE_PASS_SPACES_REMOVED = "Пробелы были удалены из пароля";


    @Description("Тест поля ввода пароля")
    @Test()
    @Owner("Rudenok_B")
    public void testPassField() {
        loginScreen.waitLoadApp();
        loginScreen.inputPassFromKeyboard("a".repeat(49));
        softly.assertThat(loginScreen.takeTextFromPassField().length()).isEqualTo(49).as("check the number of characters");
        loginScreen.inputPassFromKeyboard("a".repeat(50));
        softly.assertThat(loginScreen.takeTextFromPassField().length()).isEqualTo(50).as("check the number of characters");
        loginScreen.inputPassFromKeyboard("a".repeat(51));
        softly.assertThat(loginScreen.takeTextFromPassField().length()).isEqualTo(50).as("check the number of characters");
        loginScreen.inputPassFromKeyboard(INVALID_PASS);
        try {
            softly.assertThat(ERROR_MESSAGE_PASS_CANNOT_CONTAIN_SPACES).isEqualTo(loginScreen.errorMessageInvalidLogin.getText());
        } catch (Exception e) {
            softly.fail("error message not found exception");
            utils.takeScreenshot("error message not found");
        }
        loginScreen.loginField.click();
        try {
            softly.assertThat(ERROR_MESSAGE_PASS_CANNOT_CONTAIN_SPACES).isEqualTo(loginScreen.errorMessagePassCannotContainSpaces.getText());
        } catch (Exception e) {
            softly.fail("error message not found with refocused");
            utils.takeScreenshot("error message not found with refocused");
        }
        loginScreen.pastePass(INVALID_PASS);
        try {
            softly.assertThat(ERROR_MESSAGE_PASS_SPACES_REMOVED).isEqualTo(loginScreen.errorMessagePassSpacesRemoved.getText());
        } catch (Exception e) {
            softly.fail("error message not found exception");
            utils.takeScreenshot("error message not found");
        }
        softly.assertThat("aa").isEqualTo(loginScreen.takeTextFromLoginField());
        loginScreen.inputPassFromKeyboard(VALID_PASS);
        softly.assertThat(VALID_PASS).isEqualTo(loginScreen.takeTextFromLoginField());
        try {
            softly.assertThat(ERROR_MESSAGE_PASS_CANNOT_CONTAIN_SPACES).isEqualTo(loginScreen.errorMessagePassCannotContainSpaces.getText());
        } catch (Exception ignored) {
        }
        softly.assertThat(true).isEqualTo(Boolean.parseBoolean(loginScreen.checkPassHiding()));
        utils.takeScreenshot("characters in the password field are hidden");
        loginScreen.selectShowPass();
        softly.assertThat(false).isEqualTo(Boolean.parseBoolean(loginScreen.checkPassHiding()));
        utils.takeScreenshot("characters in the password field are visible");
        softly.assertAll();
    }
}
