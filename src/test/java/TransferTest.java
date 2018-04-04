import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import scenarios.AddNewAccountScenario;
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
    public void shouldSendTransfer() {
        accountPage
                .openTransferPage()
                .setAmmountTransfer("100")
                .setAccountFromTransfer()
                .setAccountToTransfer()
                .clickTransfer()
                .transferAssertion.isTransferCompleted();

    }

    @Test
    public void shouldSendTransferWithRounding() {
        accountPage
                .openTransferPage()
                .setAmmountTransfer("0.0059")
                .setAccountFromTransfer()
                .setAccountToTransfer()
                .clickTransfer()
                .transferAssertion.isTransferCompleted();
    }

    @Test(priority = 9)
    public void shouldSendTransferAfterTransferWithRounding() {
        accountPage
                .openTransferPage()
                .setAmmountTransfer("0.01")
                .setAccountFromTransfer()
                .setAccountToTransfer()
                .clickTransfer();
        accountPage
                .openTransferPage()
                .transferAssertion.isTransferAvailable();

    }

    @Test
    public void shouldNotSendTransfer() {
        accountPage
                .openTransferPage()
                .setAmmountTransfer(" ")
                .setAccountFromTransfer()
                .setAccountToTransfer()
                .clickTransfer()
                .transferAssertion.isTransferWrong();
    }

    @Test
    public void shouldNotSendZeroTransfer() {
        accountPage
                .openTransferPage()
                .setAmmountTransfer("0")
                .setAccountFromTransfer()
                .setAccountToTransfer()
                .clickTransfer()
                .transferAssertion.isTransferWrong();
    }

    @Test
    public void shouldNotSendTransferWithIncorrectValue() {
        accountPage
                .openTransferPage()
                .setAmmountTransfer("test@!")
                .setAccountFromTransfer()
                .setAccountToTransfer()
                .clickTransfer()
                .transferAssertion.isTransferWrong();
    }

}
