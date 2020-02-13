package by.epamlab.webdriver_basics.page;

import by.epamlab.webdriver_basics.driver.DriverSingleton;
import by.epamlab.webdriver_basics.service.ConfigReader;
import by.epamlab.webdriver_basics.service.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractPage {

    private WebDriver driver = DriverSingleton.getDriver();
    private int explicitTimeout = Integer.parseInt(ConfigReader.get(Constants.COMMON_TIMEOUT));
    private int implicitTimeout = Integer.parseInt(ConfigReader.get(Constants.IMPLICIT_WAIT));
    private WebDriverWait wait = new WebDriverWait(driver, explicitTimeout);

    {
        driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
    }

    protected AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    protected void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    protected void setValue(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }
}
