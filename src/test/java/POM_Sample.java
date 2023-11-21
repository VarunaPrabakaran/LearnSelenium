import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LoginPageObject;
import pageObjects.Login_CheckInvalidCredentials;

public class POM_Sample {
    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        invalidLogin();
        //successfulLogin();
    }

    public static void invalidLogin() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","//Users//praba//Documents//Varu_Selenium_Projects//Drivers//chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";

        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        Login_CheckInvalidCredentials validateErrorMsg = new Login_CheckInvalidCredentials(driver);
        validateErrorMsg.wrongUserName("Apple");
        validateErrorMsg.wrongPassword("Sweet");
        validateErrorMsg.clickLoginBtn();
        String actualErrorMsg = driver.findElement(By.tagName("h3")).getText();

        try {
            Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //System.out.println("Test passed");
        //Thread.sleep(1000);
        finally {
            driver.close();
            driver.quit();
        }
    }

    public static void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        LoginPageObject.userName(driver).sendKeys("standard_user");
        LoginPageObject.password(driver).sendKeys("secret_sauce");
        LoginPageObject.login_Btn(driver).click();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
