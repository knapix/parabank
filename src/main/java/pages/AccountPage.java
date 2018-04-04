package pages;

import assertions.LoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends MainPage {
    public LoginAssertion loginAssertion;

    @FindBy(css = "[href*='openaccount.htm']")
    WebElement openAccountLink;

    @FindBy(css = "[href^='/parabank/transfer.htm']")
    WebElement clickTransferFunds;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver);
    }

    public OpenAccountPage openNewAccount() {
        openAccountLink.click();
        return new OpenAccountPage(driver);
    }

    public TransferPage openTransferPage(){
        clickTransferFunds.click();
        return new TransferPage(driver);
    }
}

