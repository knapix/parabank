package scenarios;

import pages.AccountPage;
import pages.IndexPage;

public class LoginScenario implements Scenario<IndexPage, AccountPage> {

    private String login;
    private String password;

    public LoginScenario(String login, String password) {
        this.login = login;
        this.password = password;
    }

   @Override
    public AccountPage run(IndexPage entry) {
        return entry.openIndexPage()
                .setLogin(login)
                .setPassword(password)
                .clickLoginButton();
    }
}
