package by.epamlab.webdriver_basics.page;

import by.epamlab.webdriver_basics.form.MailSendingForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmailDraftPage extends EmailPage {

    @FindBy(xpath = "//*[@class='stop-animate']/ancestor::a[contains(@href, '/drafts/')]")
    private List<WebElement> mailsList;

    public int getMailsAmountInFolder() {
        return mailsList.size();
    }

    public MailSendingForm openLastAddedMail() {
        if(mailsList.size() <= 0) {
            throw new AssertionError("Draft folder is empty");
        }
        clickElement(mailsList.get(0));
        return new MailSendingForm();
    }
}
