import org.testng.annotations.*;
import pages.IndexPage;
import scenarios.RegisterScenario;

public class LoginTestWithScenario extends MainTest {

   // private IndexPage indexPage;




    @BeforeMethod
    public void beforeTest() {
        indexPage.run(new RegisterScenario(username))
                .clickLogoutButton();
    }
   // private String login = username;

   private String password = "123456";


    @Test
    //@Parameters({"password"})
    public void shouldLoginAsNewRegistered() {
        indexPage
                .setLogin(username)
                .setPassword(password)
                .clickLoginButton()
                .loginAssertion.isUserLoggedIn();
    }
}
