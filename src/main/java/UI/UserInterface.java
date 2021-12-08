package UI;

import DatabaseQuery.QueryCommandController;
import Stock.Portfolio;
import Stock.StockMenu;
import clearScreen.clearScreen;

import java.util.Scanner;

public class UserInterface implements UI{
    @Override
    public void showInterface() throws Exception {
        int userSelectNumber = 0;
        while (userSelectNumber!=4){
            System.out.println("---------------------");
            System.out.println("종목 선택하기: 1");
            System.out.println("포트폴리오 보기: 2");
            System.out.println("회원 탈퇴하기: 3");
            System.out.println("프로그램 종료하기: 4");
            System.out.println("---------------------");
            Scanner scanner1 = new Scanner(System.in);
            userSelectNumber= scanner1.nextInt();
            switch (userSelectNumber){
                case 1:
                    StockMenu stockMenu = new StockMenu();
                    stockMenu.showMenu();
                    stockMenu.selectMenu();
                    stockMenu.selectPrice();
                    break;
                case 2:
                    Portfolio portfolio = new Portfolio();
                    portfolio.showMenu();
                    break;
                case 3:
                    clearScreen.clear();
                    System.out.println("정말로 탈퇴하시겠습니까?");
                    System.out.println("no OR yes");
                    Scanner scanner = new Scanner(System.in);
                    String select= scanner.nextLine();
                    if(select == "no"){}
                    else if(select=="yes"){
                        QueryCommandController queryCommandController = QueryCommandController.getQueryController();
                        queryCommandController.deleteUser();
                        userSelectNumber=4;
                    }
                    break;
            }
        }
    }
}
