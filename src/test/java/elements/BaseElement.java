package elements;

import driver.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BaseElement {
    private PointOption pointOption;
    private TouchAction touchAction = new TouchAction(MobileDriver.getMobileDriver());

    private final By locator;
    private final String placeholder;

    BaseElement(By locator, String placeholder) {
        this.locator = locator;
        this.placeholder = placeholder;
    }

    public List<?> getElements() {
        return MobileDriver.getMobileDriver().findElements(this.locator);
    }

    /**
     * Метод получения веб элемента
     */
    public WebElement getElement() {
        return MobileDriver.getMobileDriver().findElement(this.locator);
    }

    public boolean isDisplayed() {
        return this.getElement().isDisplayed();
    }

    public boolean isEnabled() {
        try {
            return this.getElement().isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void click() {
        this.getElement().click();
    }

    public void doubleClick() {
        pointOption = PointOption.point(this.getElement().getLocation().getX(), this.getElement().getLocation().getY());
        touchAction.tap(pointOption).tap(pointOption).perform();
    }


    public String getText() {
        return this.getElement().getText();
    }

    public String getAttribute(String attribute) {
        return this.getElement().getAttribute(attribute);
    }

    /**
     * Метод получения локации элемента
     */
    public Point takeLocation(){
        return getElement().getLocation();
    }


}
