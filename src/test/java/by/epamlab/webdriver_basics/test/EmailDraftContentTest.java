package by.epamlab.webdriver_basics.test;

import by.epamlab.webdriver_basics.page.EmailDraftPage;
import by.epamlab.webdriver_basics.form.MailSendingForm;
import by.epamlab.webdriver_basics.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Listeners({TestListener.class})
public class EmailDraftContentTest {

    @Parameters({"email-addressee", "email-subject", "email-body"})
    @Test(description = "Check that content of draft mail meets the requirements")
    public void testDraftMailContent(String expectedAddressee, String expectedSubject, String expectedBody) {
        Map<String, String> expectedContent =
                createMapWithMailContent(expectedAddressee, expectedSubject, expectedBody);
        Map<String, String> actualContent = getDraftMailContent();
        Assert.assertEquals(expectedContent, actualContent);
    }

    private Map<String, String> createMapWithMailContent(String addressee, String subject, String body) {
        Map<String, String> mailContent = new HashMap<>();
        mailContent.put("Addressee", addressee);
        mailContent.put("Subject", subject);
        mailContent.put("Body", body);
        return mailContent;
    }

    private Map<String, String> getDraftMailContent() {
        MailSendingForm sendingForm = new EmailDraftPage().openLastAddedMail();
        String addressee = sendingForm.getMailAddressee();
        String subject = sendingForm.getMailSubject();
        String body = sendingForm.getMailBodyWithoutSignature();
        sendingForm.closeSendingForm();
        return createMapWithMailContent(addressee, subject, body);
    }
}
