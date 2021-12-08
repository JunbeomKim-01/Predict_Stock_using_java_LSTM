package Login;

import Database.UserDAO;

import UI.*;
import clearScreen.*;
import java.util.Scanner;
import Storage.*;


public class UserLogin implements Login {
    public void loginCheck() throws Exception {
        try {
            System.out.println("기존 ID로 로그인: 1");
            System.out.println("회원가입: 2");
            Scanner scanner = new Scanner(System.in);
            int num =scanner.nextInt();
            UserInterface userInterface = new UserInterface();
            clearScreen.clear();
            switch (num){
                case 1:
                    setInfo();
                    if (UserDAO.login()==1) {
                        userInterface.showInterface();
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

}
