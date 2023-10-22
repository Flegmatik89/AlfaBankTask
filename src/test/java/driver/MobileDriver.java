package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigManager;

import java.io.File;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Log4j2
public class MobileDriver {
    private static AppiumDriver instance;
    public static final String BASE_URL = "Url_Appium_Server";
    public static final String NAME_DRIVER = "NameDriver";
    public static final String IOS = "IOS";
    public static final String ANDROID = "ANDROID";
    public static final long IMPLICITLY_WAIT_SEC = 5;
    private static final String PATH_TO_APP = new File("./src/test/resources/apk_files/app-debug.apk").getAbsolutePath();
    private static final String APP_PACKAGE = ConfigManager.getPropertyConfDriver("appPackage");

    /**
     * Составляет строку Capabilities для сетапа драйвера
     *
     * @param properties данные из проперти файла conf ios, Android
     * @return Capabilities для сетапа драйвера
     */
    private static DesiredCapabilities setupDriver(Set<String> properties) {
        DesiredCapabilities driverCapabilities = new DesiredCapabilities();
        for (String property : properties) {
            driverCapabilities.setCapability(property, ConfigManager.getPropertyConfDriver(property));
        }
        return driverCapabilities;
    }

    private MobileDriver() {

    }

    public static AppiumDriver<?> getMobileDriver() {
        if (instance == null) {
            synchronized (MobileDriver.class) {
                if (instance == null) {
                    instance = getDriver();
                }
            }
        }
        return instance;
    }

    /**
     * Метод для сетапа драйвера для платформы которая указана в проперти файле conf
     *
     * @return возвращает драйвер с указанными Capabilities
     */
    private static AppiumDriver<?> getDriver() {
        try {
            if (instance == null) {
                DesiredCapabilities capabilities;
                Set<String> driverProperty = ConfigManager.getDriverPropertyStr();
                switch (ConfigManager.getPropertyConf(NAME_DRIVER)) {
                    case IOS:
                        capabilities = setupDriver(driverProperty);
                        instance = new IOSDriver(new URL(ConfigManager.getPropertyConf(BASE_URL)), capabilities);
                        instance.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SEC, TimeUnit.SECONDS);
                        break;
                    case ANDROID:
                        capabilities = setupDriver(driverProperty);
                        capabilities.setCapability(MobileCapabilityType.APP, PATH_TO_APP);
                        instance = new AndroidDriver(new URL(ConfigManager.getPropertyConf(BASE_URL)), capabilities);
                        instance.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SEC, TimeUnit.SECONDS);
                        break;
                    default:
                        throw logBrowserNotSupported();
                }
            }
        } catch (Exception e) {
            log.error("driver setup error, in class" + MobileDriver.class.getSimpleName(), e);
            System.out.println("driver setup error, in class" + MobileDriver.class.getSimpleName() + e);
        }
        return instance;
    }

    public static void tearDown() {
        getDriver().closeApp();
        getDriver().removeApp(APP_PACKAGE);
    }

    public static void setUp() {
        if (!getDriver().isAppInstalled(APP_PACKAGE)) {
            getDriver().installApp(PATH_TO_APP);
            getDriver().activateApp(APP_PACKAGE);
        }
    }


    public static boolean keyboardShow() {
        return ((AndroidDriver) getDriver()).isKeyboardShown();
    }

    @NotNull
    private static WebDriverException logBrowserNotSupported() {
        WebDriverException ex = new WebDriverException("driver is not supported");
        log.debug(ex.getMessage(), ex.getCause());
        return ex;
    }
}
