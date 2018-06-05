package interfaces;

import Models.News;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by Admin on 6/1/2018.
 */
public interface I_NewsContentAdder {
    void addContent(WebDriver driver, ArrayList<News> newss);
}
