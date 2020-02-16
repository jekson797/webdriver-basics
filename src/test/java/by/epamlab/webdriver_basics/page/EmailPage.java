package by.epamlab.webdriver_basics.page;

import by.epamlab.webdriver_basics.form.MailSendingForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='/inbox/']")
    private WebElement inboxBtn;

    @FindBy(css = ".compose-button__wrapper")
    private WebElement writeLetterBtn;

    @FindBy(xpath = "//a[@href='/drafts/']")
    private WebElement draftBtn;

    @FindBy(xpath = "//a[@href='/sent/']")
    private WebElement sentBtn;

    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    private WebElement logoutBtn;

    public EmailPage pressInboxBtn() {
        waitUntilElementToBeClickable(inboxBtn);
        clickElement(inboxBtn);
        return this;
    }

    public String getUrl() {
        waitUntilElementToBeClickable(inboxBtn);
        return getPageUrl();
    }

    public EmailDraftPage pressDraftBtn() {
        waitUntilElementToBeClickable(draftBtn);
        clickElement(draftBtn);
        return new EmailDraftPage();
    }

    public EmailSentPage pressSentBtn() {
        waitUntilElementToBeClickable(sentBtn);
        clickElement(sentBtn);
        return new EmailSentPage();
    }

    public MailSendingForm pressWriteLetterBtn() {
        clickElement(writeLetterBtn);
        return new MailSendingForm();
    }

    public void pressLogout() {
        waitUntilElementToBeClickable(logoutBtn);
        clickElement(logoutBtn);
    }
}
