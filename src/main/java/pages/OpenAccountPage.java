package pages;

import assertions.AccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

public class OpenAccountPage extends MainPage {
    @FindBy(css ="[name='type']")
    private WebElement accountTypeSelect;

    @FindBy(css = "[name='fromAccountId']")
    private WebElement accountNumberSelect;

    @FindBy(css = "[value='Open New Account']")
    private WebElement openNewAccountButton;
    public AccountAssertion accountAssertion;

    public OpenAccountPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver,this);
        accountAssertion = new AccountAssertion(driver, context);
    }

    public OpenAccountPage setAccountType(String value) {
        new Select(accountTypeSelect).selectByValue(value);
        return this;
    }

    public OpenAccountPage setAccountForTransfer(String account) {
        new Select(accountNumberSelect).selectByValue(getContextAttribute(account));
//        new Select(accountNumberSelect).selectByIndex(0);
        return this;
    }

    public OpenAccountPage clickOpenNewAccount() {
        openNewAccountButton.click();
        return this;
    }
}
