package scenarios;

import pages.AccountPage;
import pages.OpenAccountPage;

public class AddNewAccountScenario implements Scenario<AccountPage, OpenAccountPage> {

    public String accountType;
    public String accountNumber;

    public AddNewAccountScenario(String accountType, String accountNumber){
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    @Override
    public OpenAccountPage run(AccountPage entry){
        return entry.openNewAccount()
                .setAccountType(accountType)
                .setAccountForTransfer(accountNumber)
                .clickOpenNewAccount();
    }
}
