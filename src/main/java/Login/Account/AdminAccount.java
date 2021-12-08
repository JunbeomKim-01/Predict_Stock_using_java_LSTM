package Login.Account;

import Login.AIAdminLogin;
import Login.Account.Account;
import Login.DBAdminLogin;
import lombok.extern.java.Log;

import java.util.Scanner;

public class AdminAccount implements Account {
    @Override
    public void login() {
        System.out.println("1: DB-Admin Login");
        System.out.println("2: AI-Admin Login");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                DBAdminLogin dbAdminLogin= new DBAdminLogin();
                dbAdminLogin.setInfo();
                break;
            case 2:
                AIAdminLogin aiAdminLogin = new AIAdminLogin();
                aiAdminLogin.setInfo();
                break;
        }
    }
}
