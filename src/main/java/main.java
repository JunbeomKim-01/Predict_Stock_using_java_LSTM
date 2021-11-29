import java.util.Scanner;

import Login.Account.Account;
import Database.DatabaseAcessObject;
import Login.*;
import Login.Account.AccountFactory;
import Login.Account.AdminAccount;
import Login.Account.UserAccount;
import clearScreen.*;

public class main {
    public static void main(String[] args) throws Exception {
        Account account;
        DatabaseAcessObject.connectDatabase();
        AccountFactory accountFactory = new AccountFactory();

        System.out.println("User Login : 1");
        System.out.println("Admin Login : 2");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        account=accountFactory.createAccount(userInput);
        clearScreen.clear();

        try {
            if (account instanceof UserAccount) {
                UserAccount user  = (UserAccount) account;
                user.login();
            }
            else if(account instanceof AdminAccount) {
                AdminAccount adminAccount= (AdminAccount) account;
                adminAccount.login();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}