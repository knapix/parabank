package pages;

import assertions.LoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import java.util.List;

public class AccountPage extends MainPage {
    public LoginAssertion loginAssertion;

    @FindBy(css = "[href*='openaccount.htm']")
    WebElement openAccountLink;

    @FindBy(css = "[href^='/parabank/transfer.htm']")
    WebElement clickTransferFunds;

    @FindBy(css = "#accountTable a")
    private List<WebElement> accountsElements;


    public AccountPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver, context);
    }

    public OpenAccountPage openNewAccount() {
        openAccountLink.click();
        return new OpenAccountPage(driver, getContext());
    }

    public TransferPage openTransferPage(){
        clickTransferFunds.click();
        return new TransferPage(driver, getContext());
    }

    public AccountPage getAccount(String account){                  //ITestcontext
        String accountValue = accountsElements.get(0).getText();
        setContextAttribute(account, accountValue);
        return this;
    }
}

