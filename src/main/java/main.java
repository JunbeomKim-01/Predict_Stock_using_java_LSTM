import java.sql.SQLException;
import java.util.Scanner;

import DatabaseQuery.QueryCommandController;
import DatabaseQuery.Querys.DeleteQuery.DeleteStockCodeQuery;
import DatabaseQuery.Querys.DeleteQuery.DeleteUserQuery;
import DatabaseQuery.Querys.InsertQuery.InsertStockCodeQuery;
import DatabaseQuery.Querys.InsertQuery.InsertUserInfoQuery;
import DatabaseQuery.Querys.InsertQuery.InsertUserQuery;
import DatabaseQuery.Querys.SelectQuery.SelectStockCodeQuery;
import DatabaseQuery.Querys.SelectQuery.SelectUserInfoQuery;
import DatabaseQuery.commands.DeleteCommand.DeleteStockCodeCommand;
import DatabaseQuery.commands.DeleteCommand.DeleteUserCommand;
import DatabaseQuery.commands.InsertCommand.InsertStockCodeCommand;
import DatabaseQuery.commands.InsertCommand.InsertUserCommand;
import DatabaseQuery.commands.InsertCommand.InsertUserInfoCommand;
import DatabaseQuery.commands.SelectCommand.SelectStockCodeCommand;
import DatabaseQuery.commands.SelectCommand.SelectUserInfoCommand;
import Login.Account.Account;
import Database.DatabaseAcessObject;
import Login.*;
import Login.Account.AccountFactory;
import Login.Account.AdminAccount;
import Login.Account.UserAccount;
import clearScreen.*;

public class main {
    public static void main(String[] args) throws Exception {
        init();
        if (DatabaseAcessObject.connectDatabase()==0){
            return;
        }
        Account account;
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
    public static void init() throws SQLException {
        SelectStockCodeCommand selectStockCodeCommand= new SelectStockCodeCommand(new SelectStockCodeQuery());
        SelectUserInfoCommand selectUserInfoCommand= new SelectUserInfoCommand(new SelectUserInfoQuery());
        InsertStockCodeCommand insertStockCodeCommand = new InsertStockCodeCommand(new InsertStockCodeQuery());
        InsertUserCommand insertUserCommand = new InsertUserCommand(new InsertUserQuery());
        InsertUserInfoCommand insertUserInfoCommand = new InsertUserInfoCommand(new InsertUserInfoQuery());
        DeleteUserCommand deleteUserCommand = new DeleteUserCommand(new DeleteUserQuery());
        DeleteStockCodeCommand deleteStockCodeCommand = new DeleteStockCodeCommand(new DeleteStockCodeQuery());
        QueryCommandController.setCommand(selectUserInfoCommand,selectStockCodeCommand,insertStockCodeCommand,insertUserCommand,insertUserInfoCommand,deleteStockCodeCommand,deleteUserCommand);
    }
}