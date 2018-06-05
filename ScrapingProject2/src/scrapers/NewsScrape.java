package scrapers;

import Abstract.Scrape;
import Models.News;
import configs.Config;
import contentAdders.NewsAddContent;
import interfaces.I_NewsScraper;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Admin on 6/1/2018.
 */
public class NewsScrape extends Scrape implements Runnable{
    private HashMap<String,String> mStringHashMap = new HashMap<>();
    private long mThreadSleepTime = 60000;
    private boolean mUpdate = false;
    private NewsAddContent mNewsAddContent;
    private ArrayList<News> mNewss;
    private I_NewsScraper mNewsScraper;
    private String mType = Config.DOMESTIC;

    public NewsScrape(I_NewsScraper newsScraper, String url, WebDriver webDriver, NewsAddContent newsAddContent){
        super(url,webDriver);
        setNewsScraper(newsScraper);
        setNewsAddContent(newsAddContent);
    }

    public NewsScrape(I_NewsScraper newsScraper, String url, WebDriver webDriver, NewsAddContent newsAddContent, long threadSleepTime){
        new NewsScrape(newsScraper,url,webDriver, newsAddContent);
        setThreadSleepTime(threadSleepTime);
    }

    @Override
    public void run(){
        while(true){
            getWebDriver().get(getUrl());
            setStringHashMap(mNewsScraper.scrape(getWebDriver()));
            if(isUpdate()){
                setNewss(getStringHashMap());
                getNewsAddContent().setNewss(getNewss());
                (new Thread(getNewsAddContent())).start();
                setWebDriver(null);
                setUpdate(false);
            }else{
                setWebDriver(null);
            }

            try {
                Thread.sleep(getThreadSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public HashMap<String, String> getStringHashMap() {
        return mStringHashMap;
    }

    public void setStringHashMap(HashMap<String, String> stringHashMap) {
        for (String key:
             stringHashMap.keySet()) {
            if(!mStringHashMap.containsKey(key)){
                mStringHashMap.put(key,stringHashMap.get(key));
                setUpdate(true);
            }
        }

    }

    public long getThreadSleepTime() {
        return mThreadSleepTime;
    }

    public void setThreadSleepTime(long threadSleepTime) {
        mThreadSleepTime = threadSleepTime;
    }

    public boolean isUpdate() {
        return mUpdate;
    }

    public void setUpdate(boolean update) {
        mUpdate = update;
    }

    public NewsAddContent getNewsAddContent() {
        return mNewsAddContent;
    }

    public void setNewsAddContent(NewsAddContent newsAddContent) {
        mNewsAddContent = newsAddContent;
    }

    public ArrayList<News> getNewss() {
        return mNewss;
    }

    public void setNewss(ArrayList<News> newss) {
        mNewss = newss;
    }

    private void setNewss(HashMap<String,String> stringHashMap){
        ArrayList<News> result = new ArrayList<>();
        for (String key:
             stringHashMap.keySet()) {
            setUpdate(true);
            News news = new News(key,stringHashMap.get(key),getType());
            result.add(news);
        }
        mNewss = result;
    }
    public I_NewsScraper getNewsScraper() {
        return mNewsScraper;
    }

    public void setNewsScraper(I_NewsScraper newsScraper) {
        mNewsScraper = newsScraper;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
