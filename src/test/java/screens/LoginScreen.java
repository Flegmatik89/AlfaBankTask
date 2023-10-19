package screens;

import elements.Button;
import elements.TextField;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {
    private final TextField alfaTitle = new TextField(By.id("com.alfabank.qapp:id/tvTitle"), "Title alfa-test");
    private final TextField loginField = new TextField(By.id("com.alfabank.qapp:id/etUsername"), "login input field");
    private final TextField passField = new TextField(By.id("com.alfabank.qapp:id/etPassword\n"), "password input field");
    private final Button loginButton = new Button(By.xpath("//*[@text = 'Вход']"), "login button");


    @Step("take text Alfa Title")
    public String takeTextAlfaTitle(){
        return alfaTitle.getText();
    }

    @Step("check display Alfa Title")
    public boolean checkDisplayAlfaTitle(){
        return Boolean.parseBoolean(alfaTitle.getAttribute("displayed"));
    }

    @Step("Checking the clickability Alfa Title")
    public boolean checkClickableAlfaTitle(){
        return Boolean.parseBoolean(alfaTitle.getAttribute("clickable"));

    }

    @Step("input login")
    public void inputLogin(String login){
        loginField.clearAndSetText(login);
    }

    @Step("input password")
    public void inputPass(String pass){
        passField.clearAndSetText(pass);
    }

    @Step("select login button")
    public void selectLoginButton(){
        loginButton.click();
    }
}
