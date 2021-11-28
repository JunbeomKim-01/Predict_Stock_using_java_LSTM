package Login;

import Database.UserDAO;
import DatabaseQuery.Context;
import DatabaseQuery.DeletQuery;
import Stock.*;
import clearScreen.*;
import java.util.Scanner;
import Storage.*;


public class UserLogin extends Person<UserDAO> implements Login, UI {
    public UserLogin() throws Exception {
        try {
            loginCheck();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loginCheck() throws Exception {
        try {
            System.out.println("기존 ID로 로그인: 1");
            System.out.println("회원가입: 2");
            Scanner scanner = new Scanner(System.in);
            int num =scanner.nextInt();
            clearScreen.clear();
            switch (num){
                case 1:
                    setInfo();
                    if (UserDAO.login()==1) {
                     showInterface();
                    }
                    break;
                case 2:
                    LoginControll.createAccount();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    };
    @Override
    public void setInfo() {
        System.out.println("user-ID를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        Storage.setId(scanner.nextLine());

        clearScreen.clear();

        System.out.println("user-Password를 입력해주세요");
        Scanner scanner1 = new Scanner(System.in);
        Storage.setPassword(scanner1.nextLine());

        clearScreen.clear();
    }

    @Override
    public void doCall() {
        //정상
        this.DAO.Exception("SELECT * FROM DB");
        //ERROR
        this.DAO.Exception("INSERT * VALUES(....)");
    }

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
                        Context context = new Context(new DeletQuery());
                        context.excuteQuery("User",null);
                    }
                    break;
            }
        }
    }
}
