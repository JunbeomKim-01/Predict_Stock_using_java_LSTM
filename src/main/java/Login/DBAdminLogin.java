package Login;

import Database.DBAminDAO;
import Storage.Storage;
import UI.*;
import clearScreen.*;

import java.util.Scanner;

public class DBAdminLogin extends Person<DBAminDAO> implements Login {
    @Override
    public void setInfo() {
        try{
            DBAdminInterface dbAdminInterface= new DBAdminInterface();
            System.out.println("DB-admin-ID를 입력해주세요");
            Scanner scanner = new Scanner(System.in);
            Storage.setId(scanner.nextLine());
            clearScreen.clear();

            System.out.println("DB-admin-Password를 입력해주세요");
            Scanner scanner1= new Scanner(System.in);
            Storage.setPassword(scanner1.nextLine());
            clearScreen.clear();

            if (DBAminDAO.login()==1){
                dbAdminInterface.showInterface();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doCall() {
        //정상
        this.DAO.Exception("SELECT * FROM DB");

        //정상
        this.DAO.Exception("INSERT * VALUES(....)");
    }

}
