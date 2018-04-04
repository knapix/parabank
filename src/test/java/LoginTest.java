
import org.testng.annotations.Test;


public class LoginTest extends MainTest {


    private String login = "username209";
    private String password = "123456";

    @Test
    public void shouldLogin() {
        indexPage.openIndexPage()
                .setLogin(login)
                .setPassword(password)
                .clickLoginButton()
                .loginAssertion
                .isUserLoggedIn();
    }

}
