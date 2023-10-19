package tests;

import driver.MobileDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static org.assertj.core.api.Java6Assertions.assertThat;

public class TitleTest extends BaseTest {
    private static final String TITLE = "Вход в Alfa-Test";

    @Description("Тест тайтла")
    @Test()
    @Owner("Rudenok_B")
    public void testTitle() {
        MobileDriver.getInstance().findElement(By.id("dfdf")).click();
        assertThat(loginScreen.takeTextAlfaTitle()).isEqualTo(TITLE);
        assertThat(false).isEqualTo(loginScreen.checkClickableAlfaTitle());
        assertThat(true).isEqualTo(loginScreen.checkDisplayAlfaTitle());
    }

}
