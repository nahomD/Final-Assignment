package contentAdders;

import Abstract.AddContent;
import Models.News;
import interfaces.I_NewsContentAdder;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by Admin on 6/1/2018.
 */
public class NewsAddContent extends AddContent implements Runnable{
    private ArrayList<News> mNewss;
    private I_NewsContentAdder mContentAdder;

    public NewsAddContent(I_NewsContentAdder contentAdder, String url, WebDriver webDriver){
        super(url,webDriver);
        setContentAdder(contentAdder);
    }

     @Override
    public void run() {
        WebDriver driver = getWebDriver();
        driver.get(getUrl());
        getContentAdder().addContent(driver,getNewss());
        setWebDriver(null);
    }

    public ArrayList<News> getNewss() {
        return mNewss;
    }

    public void setNewss(ArrayList<News> newss) {
        mNewss = newss;
    }

    public I_NewsContentAdder getContentAdder() {
        return mContentAdder;
    }

    public void setContentAdder(I_NewsContentAdder contentAdder) {
        mContentAdder = contentAdder;
    }


}
