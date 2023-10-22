package utils;

import driver.MobileDriver;
import enums.Direction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

@Log4j2
public class Swipe {
    private final Dimension dimension = MobileDriver.getMobileDriver().manage().window().getSize();
    private final int edgeBorder = 15;
    private PointOption pointOptionEnd;

    /**
     * Скрол экрана от середины в указанном направлении
     *
     * @param dir направление
     */
    public void customSwipe(Direction dir) {
        TouchAction action = new TouchAction(MobileDriver.getMobileDriver());
        PointOption scrollStart = PointOption.point(dimension.width / 2, dimension.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dimension.width / 2, dimension.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dimension.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dimension.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dimension.width - edgeBorder, dimension.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        action.press(scrollStart).waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
                .moveTo(pointOptionEnd).release().perform().cancel();
    }

    /**
     * Скрол экрана от вэб элемента в указанном направлении
     *
     * @param dir          направление
     * @param locatorStart локатор элемента
     */
    public void swipeFromStartPointElement(By locatorStart, Direction dir) {
        TouchAction action = new TouchAction(MobileDriver.getMobileDriver());
        PointOption scrollStart = PointOption.point(MobileDriver.getMobileDriver().findElement(locatorStart).getLocation());
        int getX = MobileDriver.getMobileDriver().findElement(locatorStart).getLocation().getX();
        int getY = MobileDriver.getMobileDriver().findElement(locatorStart).getLocation().getY();

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(getX, dimension.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(getX, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, getY);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dimension.width - edgeBorder, getY);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        action.press(scrollStart).waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
                .moveTo(pointOptionEnd).release().perform();
    }

    /**
     * Скрол экрана от точки в указанном направлении
     *
     * @param dir    направление
     * @param pointY ось x точки на эране
     * @param pointX ось y точки на эране
     */
    public void swipeFromStartPoint(int pointX, int pointY, Direction dir) {
        TouchAction action = new TouchAction(MobileDriver.getMobileDriver());
        PointOption scrollStart = PointOption.point(pointX, pointY);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(pointX, dimension.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(pointX, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, pointY);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dimension.width - edgeBorder, pointY);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        action.press(scrollStart).waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
                .moveTo(pointOptionEnd).release().perform();
    }

    /**
     * Скрол экрана от середины в указанном направлении, пока элемент не окажется в поле зрения.
     *
     * @param locatorNeed необходимый локатор
     * @param locatorStop локатор для гарантированной остановки
     * @param dir         направление
     */
    public boolean swipeToView(By locatorNeed, By locatorStop, Direction dir, int times) {
        for (int i = 0; i <= times; i++) {
            try {
                if (MobileDriver.getMobileDriver().findElement(locatorNeed).isDisplayed() ||
                        MobileDriver.getMobileDriver().findElement(locatorStop).isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
                customSwipe(dir);
            }
        }
        return false;
    }
}
