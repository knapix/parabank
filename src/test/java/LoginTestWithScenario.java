import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IndexPage;
import scenarios.RegisterScenario;

public class LoginTestWithScenario extends MainTest {

   // private IndexPage indexPage;




    @BeforeTest
    public void beforeTest() {
        indexPage.run(new RegisterScenario(username))
                .clickLogoutButton();
    }
   // private String login = username;

   private String password = "123456";


    @Test
    public void shouldLoginAsNewRegistered() {
        indexPage
                .setLogin(username)
                .setPassword(password)
                .clickLoginButton()
                .loginAssertion.isUserLoggedIn();
    }
}
