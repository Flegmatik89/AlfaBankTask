package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import driver.MobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.AllureListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import screens.LoginScreen;
import utils.Utils;


@ExtendWith(AllureListener.class)
public class BaseTest {
    Utils utils = new Utils();

    @BeforeAll
    protected static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        MobileDriver.setUp();
    }


    @AfterEach
    public void afterEach() {
        MobileDriver.tearDown();
    }



    /**
     * Экземпляры страниц
     */
    LoginScreen loginScreen = new LoginScreen();

}
