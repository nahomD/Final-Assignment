package contentAdders;

import interfaces.I_TextSender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendTextAddContent  implements I_TextSender {
    private WebElement mCompose;
    private WebElement mToField;
    private WebElement mSubject;
    private WebElement mContent;
    private WebElement mSendButton;
    @Override
    public void sendText(WebDriver driver, String phoneNumber, String text) {
        setCompose(driver.findElement(By.className("T-I J-J5-Ji T-I-KE L3")));
        getCompose().click();

        setToField(driver.findElement(By.xpath("//*[@id=\":9o\"]")));
        setSubject(driver.findElement(By.xpath("//*[@id=\":96\"]")));
        setContent(driver.findElement(By.xpath("#\\3a ab")));
        setSendButton(driver.findElement(By.xpath("//*[@id=\":8w\"]")));

        getToField().sendKeys(String.valueOf(phoneNumber+"@tmomail.net"));
        getContent().sendKeys("Notifications="+text);
        getSendButton().click();
    }

    public WebElement getCompose() {
        return mCompose;
    }

    public void setCompose(WebElement compose) {
        mCompose = compose;
    }

    public WebElement getToField() {
        return mToField;
    }

    public void setToField(WebElement toField) {
        mToField = toField;
    }

    public WebElement getSubject() {
        return mSubject;
    }

    public void setSubject(WebElement subject) {
        mSubject = subject;
    }

    public WebElement getContent() {
        return mContent;
    }

    public void setContent(WebElement content) {
        mContent = content;
    }

    public WebElement getSendButton() {
        return mSendButton;
    }

    public void setSendButton(WebElement sendButton) {
        mSendButton = sendButton;
    }
}
