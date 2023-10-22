package screens;

import elements.Button;
import elements.TextField;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {
    private static final String ALFA_TITLE = "com.alfabank.qapp:id/tvTitle";
    private static final String LOGIN_FIELD = "com.alfabank.qapp:id/etUsername";
    private static final String PASS_FIELD = "com.alfabank.qapp:id/etPassword";
    private static final String LOGIN_BUTTON = "//*[@text = 'Вход']";
    private static final String ERROR_MESSAGE_INVALID_LOGIN = "//*[@text = 'Логин может содержать только цифры и символы подчеркивания']";
    private static final String ERROR_MESSAGE_REMOVE_INVALID_SYMBOLS = "//*[@text = 'Логин может содержать только цифры и символы подчеркивания']";
    private static final String SHOW_PASS = "//android.widget.ImageButton[@content-desc=\"Show password\"]";
    private static final String ERROR_MESSAGE_PASS_CANNOT_CONTAIN_SPACES = "//*[@text = 'Пароль не может содержать пробелы']";
    private static final String ERROR_MESSAGE_PASS_SPACES_REMOVED = "//*[@text = 'Пробелы были удалены из пароля']";
    private static final String ERROR_MESSAGE_INVALID_CREDENTIALS = "com.alfabank.qapp:id/tvError";


    public final TextField alfaTitle = new TextField(By.id(ALFA_TITLE), "Title alfa-test");
    public final TextField loginField = new TextField(By.id(LOGIN_FIELD), "login input field");
    public final TextField passField = new TextField(By.id(PASS_FIELD), "password input field");
    public final Button loginButton = new Button(By.xpath(LOGIN_BUTTON), "login button");
    public final Button errorMessageInvalidLogin = new Button(By.xpath(ERROR_MESSAGE_INVALID_LOGIN), "error message");
    public final Button errorMessageRemoveInvalidSymbols = new Button(By.xpath(ERROR_MESSAGE_REMOVE_INVALID_SYMBOLS), "error message");
    public final Button errorMessagePassCannotContainSpaces = new Button(By.xpath(ERROR_MESSAGE_PASS_CANNOT_CONTAIN_SPACES), "error message");
    public final Button errorMessagePassSpacesRemoved = new Button(By.xpath(ERROR_MESSAGE_PASS_SPACES_REMOVED), "error message");
    public final Button showPass = new Button(By.xpath(SHOW_PASS), "show password button");
    public final Button errorMessageInvalidCredentials = new Button(By.id(ERROR_MESSAGE_INVALID_CREDENTIALS), "error message");


    @Step("wait Load App")
    public void waitLoadApp() {
        waits.waitForElementDisplayed(By.id(ALFA_TITLE), "application failed", 20);
    }

    @Step("take text Alfa Title")
    public String takeTextAlfaTitle() {
        return alfaTitle.getText();
    }

    @Step("check display Alfa Title")
    public boolean checkDisplayAlfaTitle() {
        return Boolean.parseBoolean(alfaTitle.getAttribute("displayed"));
    }

    @Step("checking the clickability Alfa Title")
    public boolean checkClickableAlfaTitle() {
        return Boolean.parseBoolean(alfaTitle.getAttribute("clickable"));

    }

    @Step("paste login")
    public void pasteLogin(String login) {
        loginField.click();
        loginField.clearField();
        utils.takeTextToClipboardAndPaste(login);
    }

    @Step("input login from keyboard")
    public void inputLoginFromKeyboard(String login) {
        loginField.click();
        loginField.clearField();
        loginField.setTextFromKeyboard(login);
    }

    @Step("take text from login field")
    public String takeTextFromLoginField() {
        return loginField.getText();
    }

    @Step("input password from keyboard")
    public void inputPassFromKeyboard(String pass) {
        passField.click();
        passField.clearField();
        passField.setTextFromKeyboard(pass);
    }

    @Step("paste password")
    public void pastePass(String pass) {
        passField.click();
        passField.clearField();
        utils.takeTextToClipboardAndPaste(pass);
    }

    @Step("take text from pass field")
    public String takeTextFromPassField() {
        return passField.getText();
    }

    @Step("select show password")
    public void selectShowPass() {
        showPass.click();
    }

    @Step("check password hiding")
    public String checkPassHiding() {
        return passField.getAttribute("password");
    }

    @Step("select login button")
    public void selectLoginButton() {
        loginButton.click();
    }

    @Step("take name login button")
    public String takeNameLoginButton() {
        return loginButton.getText();
    }

    @Step("take error message invalid credentials")
    public String takeErrorMessageInvalidCredentials() {
        return errorMessageInvalidCredentials.getText();
    }

    @Step("wait error message invalid credentials")
    public void waitErrorMessageInvalidCredentials() {
        waits.waitForElementDisplayed(By.id(ERROR_MESSAGE_INVALID_CREDENTIALS), "error message not displayed", 20);
    }
}
