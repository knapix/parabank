import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.IndexPage;
import pages.RegistrationPage;
import pages.WelcomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class MainTest {
    WebDriver driver;
    IndexPage indexPage;
    RegistrationPage registrationPage;
    WelcomePage welcomePage;
    AccountPage accountPage;


    String username;


    @BeforeMethod
    @Parameters({"url"})
    public void before(String url) throws MalformedURLException { driver = new ChromeDriver();

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        URL hubUrl = new URL("http://192.168.0.33:4444/wd/hub");
//        try {
//            hubUrl = new URL("http://192.168.43.36:4444");
//            //hubUrl = new URL("http://192.168.43.178:4444");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
       // driver = new RemoteWebDriver(hubUrl, capabilities);
        //driver = new RemoteWebDriver(new URL("http://192.168.43.178:4444"),capabilities);
        indexPage = new IndexPage(driver, url);
        registrationPage = new RegistrationPage(driver);
        welcomePage = new WelcomePage(driver);
        accountPage = new AccountPage(driver);

        Random rg = new Random();
        int randomInt = rg.nextInt(1000);
        username = "username" + randomInt;
    }

    @AfterMethod
    public void after() {
        driver.close();
    }
}
