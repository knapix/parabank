import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.IndexPage;
import pages.RegistrationPage;
import pages.WelcomePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class MainTest {
    WebDriver driver;
    IndexPage indexPage;   //typ nazwa
    RegistrationPage registrationPage;
    WelcomePage welcomePage;
    AccountPage accountPage;
    protected ITestContext context;


    String username;
//WEB14

    @BeforeMethod
    @Parameters({"url"})
    public void before(ITestContext context, String url) throws MalformedURLException {
        driver = new ChromeDriver();
        this.context = context;

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
    public void after(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\test-output";
                String scrennshotPath = reportDirectory + "errorScreenshots\\" + result.getName() + ".jpg";
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(scrennshotPath));
                Reporter.log("<a href='" + scrennshotPath + "'> <img src='" + scrennshotPath + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.close();


    }
}