package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import pages.MainPage;

import java.util.List;

public class RegistrationAssertion extends MainPage {

    @FindBy(css = ".title")
    private List<WebElement> welcomeMessage;

    public RegistrationAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public void isWelcomeMessageDisplayed() {
        Assert.assertTrue(welcomeMessage.size() != 0);
    }
}
