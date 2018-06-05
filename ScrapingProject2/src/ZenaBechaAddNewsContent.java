import Models.News;
import interfaces.I_NewsContentAdder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

/**
 * Created by Admin on 6/2/2018.
 */
public class ZenaBechaAddNewsContent implements I_NewsContentAdder {
    private WebElement mTitle;
    private WebElement mType;
    private WebElement mSummary;
    private WebElement mButton;

    @Override
    public void addContent(WebDriver driver, ArrayList<News> newss) {
        if(newss.size() == 0)
            return;
        setTitle(driver.findElement(By.name("title")));
        setType(driver.findElement(By.name("type")));
        setSummary(driver.findElement(By.name("summary")));
        setButton(driver .findElement(By.tagName("button")));
        for (News news:
                newss) {
            getTitle().sendKeys(news.getTitle());
            Select selectElement = new Select(getType());
            selectElement.selectByValue(news.getType());
            getSummary().sendKeys(news.getSummary());
            getButton().click();

            getTitle().clear();
            getSummary().clear();
        }
    }

    public WebElement getTitle() {
        return mTitle;
    }

    private void setTitle(WebElement title){
        mTitle = title;
    }
    public WebElement getType() {
        return mType;
    }

    private void setType(WebElement type){
        mType = type;
    }

    public WebElement getSummary() {
        return mSummary;
    }

    private void setSummary(WebElement summary){
        mSummary = summary;
    }

    public WebElement getButton() {
        return mButton;
    }

    private void setButton(WebElement button) {
        mButton = button;
    }
}
