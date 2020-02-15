package by.epamlab.webdriver_basics.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
        throw new AssertionError("Cannot be instantiated directly.");
    }

    public static WebDriver setDriver() {
        driver = createChromeDriver();
        driver.manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            return setDriver();
        }
        return driver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
