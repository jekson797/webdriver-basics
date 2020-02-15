package by.epamlab.webdriver_basics.test;

import by.epamlab.webdriver_basics.driver.DriverSingleton;
import by.epamlab.webdriver_basics.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverSingleton.setDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
