package by.epamlab.webdriver_basics.page;

import by.epamlab.webdriver_basics.driver.DriverSingleton;
import by.epamlab.webdriver_basics.service.ConfigReader;
import by.epamlab.webdriver_basics.service.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    private WebDriver driver = DriverSingleton.getDriver();
    private int explicitTimeout = Integer.parseInt(ConfigReader.get(Constants.COMMON_TIMEOUT));
    private int implicitTimeout = Integer.parseInt(ConfigReader.get(Constants.IMPLICIT_WAIT));
    private WebDriverWait wait = new WebDriverWait(driver, explicitTimeout);

    {
        driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    protected AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    protected void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilInvisibilityOfElementLocated(By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
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

    protected String getElementText(WebElement element) {
        return element.getText();
    }

    protected String getAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }
}
