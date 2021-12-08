package UI;

import Database.Management.MamberManagemenet;
import Database.Management.StockManagement;
import clearScreen.clearScreen;

import java.util.Scanner;

public class DBAdminInterface implements UI{

    @Override
    public void showInterface() throws Exception {
        int select = 0;
        while (select!=3){
            clearScreen.clear();
            System.out.println("1: 회원 관리");
            System.out.println("2: 주식 종목 관리");
            System.out.println("3: 프로그램 종료");
            Scanner scanner = new Scanner(System.in);
            select=scanner.nextInt();
            switch (select){
                case 1:
                    clearScreen.clear();
                    System.out.println("1: 회원 삭제");
                    Scanner scanner1= new Scanner(System.in);
                    MamberManagemenet mamberManagemenet = new MamberManagemenet(scanner1.nextInt());
                    break;
                case 2:
                    clearScreen.clear();
                    System.out.println("1: 주식 종목 추가");
                    System.out.println("2: 주식 종목 삭제");
                    System.out.println("3: 프로그램 종료");
                    Scanner scanner2= new Scanner(System.in);
                    StockManagement stockManagement = new StockManagement(scanner2.nextInt());
                    break;
            }
        }
    }
}
