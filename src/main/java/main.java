import java.util.Scanner;
import Storage.*;
import Database.DatabaseAcessObject;
import Login.*;
import Storage.Storage;
import clearScreen.*;

public class main {
    public static void main(String[] args) throws Exception {
        Login person;
        //Storage.makeStorage();
        DatabaseAcessObject.connectDatabase();
        System.out.println("User Login : 1");
        System.out.println("DB-Admin Login : 2");
//        System.out.println("AIAdmin Login : 3");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        clearScreen.clear();

        try {
            person = LoginControll.call(userInput);
            if (person instanceof UserLogin) {
                UserLogin user  = (UserLogin) person;
            }
            else if(person instanceof DBAdminLogin) {
                DBAdminLogin user= (DBAdminLogin) person;
            }
//            else if(person instanceof DBAdminLogin) {
//                AIAdminLogin user= (AIAdminLogin) person;
//            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}