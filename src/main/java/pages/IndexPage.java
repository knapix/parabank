package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class IndexPage extends MainPage {

    @FindBy(css = "[name=username]")
    private WebElement userNameInput;

    @FindBy(css = "[name=password]")
    private WebElement passwordInput;

    @FindBy(css = ".login .button")
    private WebElement loginButton;

    @FindBy(css = "[href^='register.htm']")
    private WebElement registerLinkButton;



    public IndexPage(WebDriver driver, String url, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        this.url = url;
    }

    public IndexPage openIndexPage() {
        driver.get(url);
        waitForJStoLoad();
        return this;
    }

    public IndexPage setLogin(String login) {
        userNameInput.sendKeys(login);
        return this;
    }

    public IndexPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public AccountPage clickLoginButton() {
        loginButton.click();
        return new AccountPage(driver);
    }

    public RegistrationPage clickRegisterLinkButton() {
        registerLinkButton.click();
        return new RegistrationPage(driver);
    }

}
