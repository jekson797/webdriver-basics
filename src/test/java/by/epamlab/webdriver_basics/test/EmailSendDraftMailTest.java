package by.epamlab.webdriver_basics.test;

import by.epamlab.webdriver_basics.page.EmailDraftPage;
import by.epamlab.webdriver_basics.page.EmailPage;
import by.epamlab.webdriver_basics.form.MailSendingForm;
import by.epamlab.webdriver_basics.page.EmailSentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailSendDraftMailTest extends MailSendingCondition {

    @Test(description = "Send mail and check its disappearing from draft folder")
    public void testDraftFolderAfterMailSending() {
        EmailDraftPage draftPage = new EmailPage().pressDraftBtn();
        int draftMailsBeforeMailSending = draftPage.getMailsAmountInFolder();
        sendLastSavedMailInDraftFolder(draftPage);
        int draftMailsAfterMailSending = draftPage.getMailsAmountInFolder();
        Assert.assertTrue(draftMailsBeforeMailSending > draftMailsAfterMailSending);
    }

    @Test(description = "Check that mail after sending presents in sent folder")
    public void testLetterPresenceInSentFolderAfterItsSending() {
        EmailSentPage sentPage = new EmailPage().pressSentBtn();
        int sentMailsAfterMailSending = sentPage.getMailsAmountInFolder();
        Assert.assertTrue(sentMailsAfterMailSending > getSentMailsBeforeSendingMail());
    }

    private void sendLastSavedMailInDraftFolder(EmailDraftPage draftPage) {
        MailSendingForm sendingForm = draftPage.openLastAddedMail();
        sendingForm.pressSendBtn();
        draftPage.refreshPage();
    }
}
