import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class AccountTest extends MainTest {
    private final String accountType = "SAVINGS";
    private final String ACCOUNT_KEY = "accountNumber";
//    private String login = "username566";
    private String password = "123456";
    private AccountPage accountPage;



    @BeforeTest
    public void beforeTest() {
        accountPage = indexPage.run(new RegisterScenario(username))
                .clickLogoutButton()
                .setLogin(username)
                .setPassword(password)
                .clickLoginButton();
    }
    // private String login = username;



//    public void beforeTest() {
//        indexPage.run(new RegisterScenario(username))
//                .clickLogoutButton();
//
//        accountPage = indexPage.run(new LoginScenario(username));    //musimy zapisac wartosc zwracana jako accountPage
//    }

    @Test
    public void shouldAddAccount() {
        accountPage
                .getAccount(ACCOUNT_KEY)
                .openNewAccount()
                .setAccountType(accountType)
                .setAccountForTransfer(ACCOUNT_KEY)
                .clickOpenNewAccount()
                .accountAssertion.isAccountCreated();
    }
}
