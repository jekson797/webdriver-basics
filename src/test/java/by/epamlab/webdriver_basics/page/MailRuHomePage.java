package by.epamlab.webdriver_basics.page;

import by.epamlab.webdriver_basics.service.ConfigReader;
import by.epamlab.webdriver_basics.service.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailRuHomePage extends AbstractPage {

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(css = ".o-control[type='submit']")
    private WebElement enterPasswordBtn;

    @FindBy(css = ".o-control[type='submit']")
    private WebElement loginBtn;

    public MailRuHomePage open() {
        String pageUrl = ConfigReader.get(Constants.MAIL_RU_HOMEPAGE_URL);
        openPage(pageUrl);
        return this;
    }

    public MailRuHomePage pressEnterPasswordBtn() {
        clickElement(enterPasswordBtn);
        return this;
    }

    public EmailPage pressLoginBtn() {
        clickElement(loginBtn);
        return new EmailPage();
    }

    public MailRuHomePage fillLoginField(String login) {
        setValue(loginField, login);
        return this;
    }

    public MailRuHomePage fillPasswordField(String password) {
        setValue(passwordField, password);
        return this;
    }
}
