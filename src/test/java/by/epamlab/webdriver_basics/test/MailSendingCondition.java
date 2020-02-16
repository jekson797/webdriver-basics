package by.epamlab.webdriver_basics.test;

import by.epamlab.webdriver_basics.page.EmailPage;
import by.epamlab.webdriver_basics.page.EmailSentPage;
import by.epamlab.webdriver_basics.utils.TestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class MailSendingCondition {

    private int sentMailsBeforeSendingMail;

    @BeforeClass
    public void setSentMailsBeforeSendingMail() {
        EmailSentPage sentPage = new EmailPage().pressSentBtn();
        sentMailsBeforeSendingMail = sentPage.getMailsAmountInFolder();
    }

    @AfterClass
    public void logOff() {
        new EmailPage().pressLogout();
    }

    public int getSentMailsBeforeSendingMail() {
        return sentMailsBeforeSendingMail;
    }
}
