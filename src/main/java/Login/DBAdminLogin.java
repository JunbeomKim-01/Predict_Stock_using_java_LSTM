package Login;

import Database.DBAminDAO;
import Database.MamberManagemenet;
import Database.StockManagement;
import Storage.Storage;
import clearScreen.*;

import java.util.Scanner;

public class DBAdminLogin extends Person<DBAminDAO> implements Login ,UI{
    String adminId;
    String adminPassword;
    int select;

    public DBAdminLogin() throws Exception {
        try{
            setInfo();
            if (DBAminDAO.login()==1){
                while (select!=3){
                    showInterface();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void setInfo() {
        System.out.println("admin-ID를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        Storage.setId(scanner.nextLine());
        clearScreen.clear();

        System.out.println("admin-Password를 입력해주세요");
        Scanner scanner1= new Scanner(System.in);
        Storage.setPassword(scanner1.nextLine());
        clearScreen.clear();
    }

    @Override
    public void doCall() {
        //정상
        this.DAO.Exception("SELECT * FROM DB");

        //정상
        this.DAO.Exception("INSERT * VALUES(....)");
    }

    @Override
    public void showInterface() throws Exception {
        while (true){
            clearScreen.clear();
            System.out.println("1: 회원 관리");
            System.out.println("2: 주식 종목 관리");
            System.out.println("3: 프로그램 종료");
            Scanner scanner = new Scanner(System.in);
            select=scanner.nextInt();
            switch (select){
                case 1:
                    MamberManagemenet mamberManagemenet = new MamberManagemenet();
                    break;
                case 2:
                    StockManagement stockManagement = new StockManagement();
                    break;
            }
            //TODO 씻고와서 어드민 UI 만들기
        }
    }
}
