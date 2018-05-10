package pages;

import assertions.RegistrationAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class WelcomePage extends MainPage {

    @FindBy(css = "[href*='logout.htm']")
    private WebElement logoutButton;

    public WelcomePage(WebDriver driver, ITestContext context) {
        super(driver, context);
        registrationAssertion = new RegistrationAssertion(driver, context);
        PageFactory.initElements(driver, this);
    }

    public RegistrationAssertion registrationAssertion;

    public IndexPage clickLogoutButton(){
        logoutButton.click();
        return new IndexPage(driver, url, getContext()); //getter ktory wyciaga context
    }

}
