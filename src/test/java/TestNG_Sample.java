import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageObjects.Login_CheckInvalidCredentials;

public class TestNG_Sample {
    static WebDriver driver = null;

    @BeforeTest
    public void setUpTest() {
        //System.setProperty("webdriver.chrome.driver","//Users//praba//Documents//Varu_Selenium_Projects//Drivers//chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test//(priority = 1)
    public static void invalidLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        Login_CheckInvalidCredentials validateErrorMsg = new Login_CheckInvalidCredentials(driver);
        validateErrorMsg.wrongUserName("Apple");
        validateErrorMsg.wrongPassword("Sweet");
        validateErrorMsg.clickLoginBtn();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @Test//(priority = 2)
    public static void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        LoginPageObject.userName(driver).sendKeys("standard_user");
        LoginPageObject.password(driver).sendKeys("secret_sauce");
        LoginPageObject.login_Btn(driver).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

