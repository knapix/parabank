package scenarios;

import pages.IndexPage;
import pages.WelcomePage;

public class RegisterScenario implements Scenario<IndexPage, WelcomePage> {

    private String username;

    public RegisterScenario(String username) {
        this.username = username;
    }

    @Override
    public WelcomePage run(IndexPage entry) {
        return entry.openIndexPage()
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
                .clickRegisterButton();
    }
}
