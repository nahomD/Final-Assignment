import interfaces.I_NewsScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin on 6/2/2018.
 */
public class EthiopianReporterNewsScrape implements I_NewsScraper {
    private String mTitle;
    private String mSummary;
    private HashMap<String,String> result;

    public EthiopianReporterNewsScrape(){
        setResult(new HashMap<>());
    }

    @Override
    public HashMap<String, String> scrape(WebDriver driver) {
        List<WebElement> newsList = driver.findElement(By.className("main")).findElements(By.className("item"));
        for (WebElement news:
             newsList) {
            setTitle(news.findElement(By.className("post-content")).findElement(By.className("post-title")).findElement(By.tagName("span")).getText());
            setSummary(news.findElement(By.className("post-content")).findElement(By.className("post-body")).getText());
            result.put(getTitle(),getSummary());
        }
        return result;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public HashMap<String, String> getResult() {
        return result;
    }

    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }
}
