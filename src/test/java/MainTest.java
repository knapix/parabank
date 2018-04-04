import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.AccountPage;
import pages.IndexPage;
import pages.RegistrationPage;
import pages.WelcomePage;

import java.util.Random;

public class MainTest {
    WebDriver driver;
    IndexPage indexPage;
    RegistrationPage registrationPage;
    WelcomePage welcomePage;
    AccountPage accountPage;


    String username;


    @BeforeTest
    @Parameters({"url"})
    public void before(String url) {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver, url);
        registrationPage = new RegistrationPage(driver);
        welcomePage = new WelcomePage(driver);
        accountPage = new AccountPage(driver);

        Random rg = new Random();
        int randomInt = rg.nextInt(1000);
        username = "username" + randomInt;
    }

    @AfterTest
    public void after() {
        driver.close();
    }
}
