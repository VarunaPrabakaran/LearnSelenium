package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
private static WebElement element = null;
public static WebElement userName(WebDriver driver){
     element = driver.findElement(By.id("user-name"));
    return element;
}
public static WebElement password(WebDriver driver){
    element = driver.findElement(By.id("password"));
    return element;
}
public static WebElement login_Btn(WebDriver driver){
    element = driver.findElement(By.id("login-button"));
    return element;
}

}
