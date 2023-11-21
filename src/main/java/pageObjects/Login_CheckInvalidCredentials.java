package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_CheckInvalidCredentials {
    WebDriver driver = null;
    By userName = By.id("user-name");
    By password = By.id("password");
    By login_Btn = By.id("login-button");

    //constructor
    public Login_CheckInvalidCredentials(WebDriver driver){
        this.driver = driver;
    }
    public void wrongUserName(String userNameTxt){
        driver.findElement(userName).sendKeys(userNameTxt);
    }
    public void wrongPassword(String passwordTxt){
        driver.findElement(password).sendKeys(passwordTxt);
    }
    public void clickLoginBtn(){
        driver.findElement(login_Btn).click();
    }
}
