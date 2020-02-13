package by.epamlab.webdriver_basics.page;

import by.epamlab.webdriver_basics.service.ConfigReader;
import by.epamlab.webdriver_basics.service.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailRuHomepage extends AbstractPage {

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(css = ".o-control[type='submit']")
    private WebElement submitBtn;

    public MailRuHomepage openMailRuHomepage() {
        String pageUrl = ConfigReader.get(Constants.MAIL_RU_HOMEPAGE_URL);
        openPage(pageUrl);
        return this;
    }

    public MailRuHomepage signInEmail(String login, String password) {
        insertLogin(login);
        clickElement(submitBtn);
        insertPassword(password);
        clickElement(submitBtn);
        return this;
    }

    private void insertLogin(String login) {
        setValue(loginField, login);
    }

    private void insertPassword(String password) {
        setValue(passwordField, password);
    }
}
