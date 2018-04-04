import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import scenarios.AddNewAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class TransferTest extends MainTest {

    public String password = "123456";
    private final String number = "123456";
    public final String type = "SAVINGS";


    @BeforeTest
    public void beforeTestScenario() {
        indexPage.run(new RegisterScenario(username))
                .clickLogoutButton()
                .setLogin(username)
                .setPassword(password)
                .clickLoginButton()
                .run(new AddNewAccountScenario(type, number));
    }

    @Test
    public void shouldSendTransfer(){
         accountPage
                .openTransferPage()
                .setAmmountTransfer("100")
                .setAccountFromTransfer()
                .setAccountToTransfer()
                .clickTransfer();

    }




}
