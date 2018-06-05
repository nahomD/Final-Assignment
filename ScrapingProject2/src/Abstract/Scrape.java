package Abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Admin on 6/1/2018.
 */
public abstract class Scrape {
    private String mUrl;
    private WebDriver mWebDriver;

    public Scrape(){

    }

    public Scrape(String url, WebDriver webDriver){
        setUrl(url);
        setWebDriver(webDriver);
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public WebDriver getWebDriver() {
        if(mWebDriver == null){
            mWebDriver = new ChromeDriver();
            return mWebDriver;
        }
        return mWebDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        if(webDriver == null){
            mWebDriver.close();
            mWebDriver = null;
        }
        mWebDriver = webDriver;
    }
}
