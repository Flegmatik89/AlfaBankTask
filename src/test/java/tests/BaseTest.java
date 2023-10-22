package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import driver.MobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.AllureListener;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import screens.LoginScreen;
import screens.LoginSuccessScreen;
import utils.Utils;


@ExtendWith(AllureListener.class)
public class BaseTest {
    protected Utils utils = new Utils();
    protected SoftAssertions softly = new SoftAssertions();

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
    protected LoginScreen loginScreen = new LoginScreen();
    protected LoginSuccessScreen loginSuccessScreen = new LoginSuccessScreen();

}
