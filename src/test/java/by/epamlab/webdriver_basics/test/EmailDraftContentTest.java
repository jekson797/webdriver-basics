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
        String addressee = sendingForm.getAddresseeFieldValue();
        String subject = sendingForm.getSubjectValue();
        String body = cutMailSignature(sendingForm.getMessageFieldValue());
        sendingForm.pressCloseBtn();
        return createMapWithMailContent(addressee, subject, body);
    }

    private String cutMailSignature(String stringWithSignature) {
        String regexForMailSignature = "\\s+ПОДПИСЬ";
        return stringWithSignature.split(regexForMailSignature)[0];
    }
}
