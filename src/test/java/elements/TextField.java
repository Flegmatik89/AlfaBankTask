package elements;

import driver.MobileDriver;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class TextField extends BaseElement {
    private final By locator;

    public TextField(By locator, String placeholder) {
        super(locator, placeholder);
        this.locator = locator;
    }

    /**
     * Метод ввода текста
     *
     * @param text текст для ввода
     */
    public void clearAndSetText(String text) {
        this.getElement().clear();
        this.getElement().sendKeys(text);
    }

    public void setTextWithoutClear(String text) {
        this.getElement().sendKeys(text);
    }

    public void clearField() {
        this.getElement().clear();
    }

    public void setTextFromKeyboard(String text){
        MobileDriver.getMobileDriver().getKeyboard().pressKey(text);
    }


}
