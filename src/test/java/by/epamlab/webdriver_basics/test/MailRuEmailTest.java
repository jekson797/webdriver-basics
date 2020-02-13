package by.epamlab.webdriver_basics.test;

import by.epamlab.webdriver_basics.page.MailRuHomepage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MailRuEmailTest {

    @Parameters({"login", "password"})
    @Test(description = "Login in email")
    public void testLoginInEmail(String login, String password) {
        MailRuHomepage mailRuHomepage = new MailRuHomepage().
                openMailRuHomepage().
                signInEmail(login, password);
        System.out.println(mailRuHomepage.getPageUrl());
    }
}
