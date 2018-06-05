import interfaces.I_FacebookLogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookEmailLogin implements I_FacebookLogIn {
    private String mEmail;
    private String mPass;

    public FacebookEmailLogin(String email, String pass){
        setEmail(email);
        setPass(pass);
    }
    @Override
    public void logIn(WebDriver webDriver) {
        WebElement email = webDriver.findElement(By.id("email"));
        WebElement pass = webDriver.findElement(By.id("pass"));
        WebElement submit = webDriver.findElement(By.id("loginbutton"));

        email.sendKeys(getEmail());
        pass.sendKeys(getPass());
        submit.click();
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPass() {
        return mPass;
    }

    public void setPass(String pass) {
        mPass = pass;
    }
}
