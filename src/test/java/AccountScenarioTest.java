import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.AddNewAccountScenario;
import scenarios.RegisterScenario;

public class AccountScenarioTest extends MainTest {


    private final String type = "SAVINGS";
    private final String number = "123456";
    private String password = "123456";
    private AccountPage accountPage;



    @BeforeTest
    public void beforeTestScenario() {
        accountPage = indexPage.run(new RegisterScenario(username))
                .clickLogoutButton()
                .setLogin(username)
                .setPassword(password)
                .clickLoginButton();
    }

    @Test
    public void shouldAddAccount2(){
        accountPage
                .run(new AddNewAccountScenario(type, number))
                    .accountAssertion.isAccountCreated();
    }
}
