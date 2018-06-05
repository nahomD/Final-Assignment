package interfaces;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Admin on 6/1/2018.
 */
public interface I_NewsScraper{
    HashMap<String,String> scrape(WebDriver driver);
}
