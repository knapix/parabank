package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import pages.MainPage;

import java.util.List;

public class AccountAssertion extends MainPage {
    @FindBy(css = "#newAccountId")
    private List<WebElement> newAccountId;

    public  AccountAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver,this);
    }

    public void isAccountCreated() {
        Assert.assertTrue(newAccountId.size()!=0);
    }
}
