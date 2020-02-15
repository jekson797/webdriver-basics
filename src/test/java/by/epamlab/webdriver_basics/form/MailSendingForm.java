package by.epamlab.webdriver_basics.form;

import by.epamlab.webdriver_basics.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailSendingForm extends AbstractPage {

    @FindBy(xpath = "//div[@data-name='to']//input")
    private WebElement addresseeFieldInput;

    @FindBy(xpath = "//div[@data-type='to']//button/preceding-sibling::span")
    private WebElement addresseeFieldValue;

    @FindBy(name = "Subject")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@role='textbox']/div")
    private WebElement messageField;

    @FindBy(xpath = "//span[@data-title-shortcut='Ctrl+S']")
    private WebElement saveBtn;

    @FindBy(xpath = "//span[@data-title-shortcut='Ctrl+Enter']")
    private WebElement sendBtn;

    @FindBy(xpath = "//button[@data-promo-id='extend']/following-sibling::button")
    private WebElement closeBtn;

    public MailSendingForm writeMailAddressee(String addressee) {
        setValue(addresseeFieldInput, addressee);
        return this;
    }

    public MailSendingForm writeMailSubject(String subject) {
        setValue(subjectField, subject);
        return this;
    }

    public void writeMailMessage(String message) {
        setValue(messageField, message);
    }

    public MailSendingForm pressSave() {
        clickElement(saveBtn);
        return this;
    }

    public void closeSendingForm() {
        clickElement(closeBtn);
    }

    public String getMailAddressee() {
        return getElementText(addresseeFieldValue);
    }

    public String getMailSubject() {
        String attributeNameWithSubjectValue = "value";
        return getAttributeValue(subjectField, attributeNameWithSubjectValue);
    }

    public String getMailBodyWithoutSignature() {
        String mailBody = getElementText(messageField);
        return cutSignature(mailBody);
    }

    public void pressSendMail() {
        clickElement(sendBtn);
        String sendingFormXpath = "//div[@class='compose-app__compose']";
        waitUntilInvisibilityOfElementLocated(By.xpath(sendingFormXpath));
    }

    private String cutSignature(String stringWithSignature) {
        String regexForMailSignature = "\\s+ПОДПИСЬ";
        return stringWithSignature.split(regexForMailSignature)[0];
    }
}
