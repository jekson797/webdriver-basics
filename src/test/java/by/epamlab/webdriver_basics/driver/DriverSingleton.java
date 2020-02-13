package by.epamlab.webdriver_basics.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
        throw new AssertionError("Cannot be instantiated directly.");
    }

    public static WebDriver setDriver() {
        switch (System.getProperty("browser", "chrome")){
            case "firefox": {
                driver = createFirefoxDriver();
                break;
            }
            case "chrome": {
                driver = createChromeDriver();
                break;
            }
            default: {
                throw new AssertionError("Browser is not correct");
            }
        }
        driver.manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            return setDriver();
        }
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
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
