import interfaces.I_NewsScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin on 6/2/2018.
 */
public class BBCNewsScrape implements I_NewsScraper {
    private String mTitle;
    private String mSummary;
    private HashMap<String,String> result;

    public BBCNewsScrape(){
        setResult(new HashMap<>());
    }
    @Override
    public HashMap<String, String> scrape(WebDriver driver) {
        List<WebElement> newsList = driver.findElements(By.className("module--news")).get(0).findElement(By.tagName("ul")).findElements(By.tagName("li"));
        for (WebElement news:
             newsList) {
            setTitle(news.findElement(By.className("media__title")).findElement(By.tagName("a")).getText());
            setSummary(news.findElement(By.className("media__summary")).getText());
            result.put(getTitle(), getSummary());
        }
        return result;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        if(title == ""){
            return;
        }
        mTitle = title;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        if(summary == ""){
            return;
        }
        mSummary = summary;
    }

    public HashMap<String, String> getResult() {
        return result;
    }

    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }
}
