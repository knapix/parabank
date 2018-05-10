package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import pages.MainPage;

import java.util.List;

public class TransferAssertion extends MainPage {
    @FindBy(css = "#amount")
    private List<WebElement> newTransferAmount;

    @FindBy(css=".error")
    private List<WebElement> transferError;

    @FindBy(css = "[value='Transfer']")
    private WebElement transferButtonAssertion;

    public TransferAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver,this);
    }

    public void isTransferCompleted() {
        Assert.assertTrue(newTransferAmount.size()!=0);
    }

    public void isTransferWrong()  {
        Assert.assertTrue(transferError.size()!=0);
    }

    public void isTransferAvailable() {Assert.assertTrue(transferButtonAssertion.isDisplayed());}


}
