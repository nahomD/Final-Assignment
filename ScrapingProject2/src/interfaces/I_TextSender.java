package interfaces;

import org.openqa.selenium.WebDriver;

public interface I_TextSender  {
    void sendText(WebDriver driver, String phoneNumber, String text);
}
