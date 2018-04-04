import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import scenarios.LoginScenario;

public class LoginScenarioTest extends MainTest {

    private String login = "username566";
    private String password = "123456";


    @Test
    public void shouldLoginFromScenario(){
        indexPage.run(new LoginScenario(login, password))
                .loginAssertion
                .isUserLoggedIn();
    }
}
