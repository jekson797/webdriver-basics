package by.epamlab.webdriver_basics.test;

import by.epamlab.webdriver_basics.page.EmailDraftPage;
import by.epamlab.webdriver_basics.page.EmailPage;
import by.epamlab.webdriver_basics.form.MailSendingForm;
import by.epamlab.webdriver_basics.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class EmailSaveMailTest {

    @Parameters({"email-addressee", "email-subject", "email-body"})
    @Test(description = "Save mail as a draft")
    public void testSavingMailAsDraft(String addressee, String subject, String body) {
        EmailDraftPage draftPage = new EmailPage().pressDraftBtn();
        int draftMailsBeforeCreatingNewOne = draftPage.getMailsAmountInFolder();
        writeMail(addressee, subject, body).saveMailAsDraft();
        int draftMailsAfterCreatingNewOne = draftPage.getMailsAmountInFolder();
        Assert.assertTrue(draftMailsAfterCreatingNewOne > draftMailsBeforeCreatingNewOne);
    }

    private EmailSaveMailTest writeMail(String addressee, String subject, String body) {
        new EmailPage().
                pressWriteLetterBtn().
                writeMail(addressee, subject, body);
        return this;
    }

    private void saveMailAsDraft() {
        new MailSendingForm().pressSave().closeSendingForm();
    }
}
