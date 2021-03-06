package pages;

import assertions.TransferAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferPage extends MainPage {

    @FindBy(css = "[id=amount]")
    private WebElement amountTransferInput;

    @FindBy(css = "[name='fromAccountId']")
    private WebElement accountFromSelect;

    @FindBy(css = "[name='toAccountId")
    private WebElement accountToSelect;

    @FindBy(css = "[value='Transfer']")
    private WebElement transferButton;

    public TransferPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //transferAssertion = new TransferAssertion();
    }


    public TransferPage setAmmountTransfer(String amount){
    amountTransferInput.sendKeys(amount);
    return this;
    }

    public TransferPage setAccountFromTransfer(){
    new Select(accountFromSelect).selectByIndex(0);
    return this;
    }

    public TransferPage setAccountToTransfer(){
        new Select(accountToSelect).selectByIndex(1);
        return this;
    }

    public TransferPage clickTransfer(){
        transferButton.click();
        return this;
    }

}
