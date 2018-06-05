import configs.Config;
import contentAdders.NewsAddContent;
import contentAdders.SendTextAddContent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import scrapers.FacebookScrape;
import scrapers.NewsScrape;

/**
 * Created by Admin on 6/2/2018.
 */
public class Main {

    public static void main(String[] args){
        System.setProperty(Config.CHROME_ID,Config.CHROME_LOCATION);
//        WebDriver[] ChromeDrive = new WebDriver[]{new ChromeDriver(),new ChromeDriver(), new ChromeDriver()};
//        NewsAddContent ZenaBecha = new NewsAddContent(new ZenaBechaAddNewsContent(),Config.ZENA_BECHA_URL, ChromeDrive[0]);
////
//        NewsScrape BBCNewsScrape = new NewsScrape(new BBCNewsScrape(),Config.BBC_NEWS_URL,ChromeDrive[1], ZenaBecha);
//        BBCNewsScrape.setType(Config.FOREIGN);
//        NewsScrape EthiopianReporterScrape = new NewsScrape(new EthiopianReporterNewsScrape(),Config.ETHIOPIAN_REPORTER_URL,ChromeDrive[2], ZenaBecha);
////
//        (new Thread(BBCNewsScrape)).start();
//        (new Thread(EthiopianReporterScrape)).start();
        FacebookEmailLogin facebookEmailLogin = new FacebookEmailLogin(Config.FACEBOOK_EMAIL, Config.FACEBOOK_PASS);
        FacebookNotifications facebookNotifications = new FacebookNotifications();
        FacebookScrape facebookScrape = new FacebookScrape(facebookEmailLogin,facebookNotifications,new ChromeDriver());
        facebookScrape.setSendTextAddContent(new SendTextAddContent());
        (new Thread(facebookScrape)).start();
    }
}
