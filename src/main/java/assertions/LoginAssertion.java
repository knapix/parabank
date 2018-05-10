package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

import java.util.List;

public class LoginAssertion extends MainPage {

    @FindBy(css = "[href$='logout.htm']")
    private WebElement logoutButton;

    @FindBy(css = ".userInfo")
    private List<WebElement> userInfoElements;


    public LoginAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isUserLoggedIn(){
        Assert.assertTrue(logoutButton.isDisplayed());
    }

}
