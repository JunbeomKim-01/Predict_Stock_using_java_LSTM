package Login;

import Database.AIAdminDAO;
import Database.DBAminDAO;
import Storage.Storage;
import UI.*;
import clearScreen.clearScreen;

import java.util.Scanner;

public class AIAdminLogin extends Person<AIAdminDAO> implements  Login{

    @Override
    public void setInfo() {
        try{
            AIAdminInterface aiAdminInterface = new AIAdminInterface();
            System.out.println("AI-admin-ID를 입력해주세요");
            Scanner scanner = new Scanner(System.in);
            Storage.setId(scanner.nextLine());
            clearScreen.clear();

            System.out.println("AI-admin-Password를 입력해주세요");
            Scanner scanner1= new Scanner(System.in);
            Storage.setPassword(scanner1.nextLine());
            clearScreen.clear();
            if (AIAdminDAO.login()==1){
                aiAdminInterface.showInterface();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doCall() {

    }
}
