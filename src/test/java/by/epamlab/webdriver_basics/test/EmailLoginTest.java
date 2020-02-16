package by.epamlab.webdriver_basics.test;

import by.epamlab.webdriver_basics.page.EmailPage;
import by.epamlab.webdriver_basics.page.MailRuHomePage;
import by.epamlab.webdriver_basics.service.ConfigReader;
import by.epamlab.webdriver_basics.service.Constants;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmailLoginTest extends CommonConditions {

    @Parameters({"login", "password"})
    @Test(description = "Login in email")
    public void testLoginInEmail(String login, String password) {
        EmailPage emailPage = signInEmail(login, password);
        String expectedURL = ConfigReader.get(Constants.MAIL_RU_EMAIL_HOMEPAGE_URL);
        String actualURL = emailPage.getUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    private EmailPage signInEmail(String login, String password) {
        return new MailRuHomePage().open().
                fillLoginField(login).pressEnterPasswordBtn().
                fillPasswordField(password).pressLoginBtn().pressInboxBtn();
    }
}
