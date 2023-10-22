package tests.loginTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class TestTitleAppLoginScreen extends BaseTest {
    private static final String TITLE = "Вход в Alfa-Test";

    @Description("Тест тайтла")
    @Test()
    @Owner("Rudenok_B")
    public void testTitle() {
        loginScreen.waitLoadApp();
        softly.assertThat(loginScreen.takeTextAlfaTitle()).isEqualTo(TITLE);
        softly.assertThat(false).isEqualTo(loginScreen.checkClickableAlfaTitle());
        softly.assertThat(true).isEqualTo(loginScreen.checkDisplayAlfaTitle());
        softly.assertAll();
    }
}
