package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class RegistrationPage extends MainPage {

    @FindBy(css = "[id='customer.firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "[id='customer.lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "[id='customer.address.street']")
    private WebElement streetInput;

    @FindBy(css = "[id='customer.address.city']")
    private WebElement cityInput;

    @FindBy(css = "[id='customer.address.state']")
    private WebElement stateInput;

    @FindBy(css = "[id='customer.address.zipCode']")
    private WebElement zipCodeInput;

    @FindBy(css = "[id='customer.phoneNumber']")
    private WebElement phoneNumberInput;

    @FindBy(css = "[id='customer.ssn']")
    private WebElement ssnInput;

    @FindBy(css = "[id='customer.username']")
    private WebElement usernameInput;

    @FindBy(css = "[id='customer.password']")
    private WebElement passwordInput;

    @FindBy(css = "[id='repeatedPassword']")
    private WebElement repeatedPasswordInput;

    @FindBy(css = "[value='Register']")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegistrationPage setStreet(String street) {
        streetInput.sendKeys(street);
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.sendKeys(state);
        return this;
    }

    public RegistrationPage setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public RegistrationPage setSsn(String ssn) {
        ssnInput.sendKeys(ssn);
        return this;
    }

    public RegistrationPage setUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage setRepeatedPassword(String repeatedPassword) {
        repeatedPasswordInput.sendKeys(repeatedPassword);
        return this;
    }

    public WelcomePage clickRegisterButton() {
        registerButton.click();
        return new WelcomePage(driver, getContext());
    }


}

