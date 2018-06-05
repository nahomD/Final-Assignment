import interfaces.I_FacebookScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookNotifications implements I_FacebookScraper {
    @Override
    public Object scrape(WebDriver driver) {
        return driver.findElement(By.id("notificationsCountValue")).getText();
    }
}
