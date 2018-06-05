package scrapers;

import Abstract.Scrape;
import configs.Config;
import contentAdders.SendTextAddContent;
import interfaces.I_FacebookLogIn;
import interfaces.I_FacebookScraper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Admin on 6/3/2018.
 */
public class FacebookScrape extends Scrape implements Runnable {
    private I_FacebookScraper mFacebookScraper;
    private I_FacebookLogIn mFacebookLogIn;
    private long mThreadSleepTime = 9000;
    private SendTextAddContent mSendTextAddContent;

    public FacebookScrape(I_FacebookLogIn facebookLogIn, I_FacebookScraper facebookScraper, WebDriver webDriver){
        super(Config.FACEBOOK_URL,webDriver);
        setFacebookScraper(facebookScraper);
        setFacebookLogIn(facebookLogIn);
    }
    @Override
    public void run() {
        getWebDriver().get(getUrl());
        getFacebookLogIn().logIn(getWebDriver());
        setUrl(getWebDriver().getCurrentUrl());
        while(true) {
            getWebDriver().get(getUrl());;
            System.out.println(getFacebookScraper().scrape(getWebDriver()));
            getSendTextAddContent().sendText(new ChromeDriver(),"251923026087", getFacebookScraper().scrape(getWebDriver()).toString());
            try {
                Thread.sleep(getThreadSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public I_FacebookScraper getFacebookScraper() {
        return mFacebookScraper;
    }

    public void setFacebookScraper(I_FacebookScraper facebookScraper) {
        mFacebookScraper = facebookScraper;
    }

    public I_FacebookLogIn getFacebookLogIn() {
        return mFacebookLogIn;
    }

    public void setFacebookLogIn(I_FacebookLogIn facebookLogIn) {
        mFacebookLogIn = facebookLogIn;
    }

    private void logIn(){
        getFacebookLogIn().logIn(getWebDriver());
    }

    public long getThreadSleepTime() {
        return mThreadSleepTime;
    }

    public void setThreadSleepTime(long threadSleepTime) {
        mThreadSleepTime = threadSleepTime;
    }

    public SendTextAddContent getSendTextAddContent() {
        return mSendTextAddContent;
    }

    public void setSendTextAddContent(SendTextAddContent sendTextAddContent) {
        mSendTextAddContent = sendTextAddContent;
    }
}
