package Login.Account;

public class AccountFactory {

    Account account;
    public Account createAccount(int select){
        switch (select){
            case 1:
                account = new UserAccount();
                break;
            case 2:
            case 3:
                account= new AdminAccount();
                break;
        }
        return account;
    }
}
