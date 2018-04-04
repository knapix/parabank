import org.testng.annotations.Test;
import pages.IndexPage;

public class RegistrationTest extends MainTest {

    @Test
    public void shouldRegisterNew() {
        indexPage.openIndexPage()
                .clickRegisterLinkButton()
                .setFirstName("Pablo")
                .setLastName("Kowalski")
                .setStreet("Slepa")
                .setCity("Big")
                .setState("NY")
                .setZipCode("123123")
                .setPhoneNumber("600600600")
                .setSsn("100100")
                .setUsername(username)
                .setPassword("123456")
                .setRepeatedPassword("123456")
                .clickRegisterButton()
                .registrationAssertion
                .isWelcomeMessageDisplayed();
        System.out.println("New Registered User: " + username);
    }
}
