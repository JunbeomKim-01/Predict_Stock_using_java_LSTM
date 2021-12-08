package DatabaseQuery.Querys.InsertQuery;

import Database.DatabaseAcessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static Login.LoginControll.memberCheck;

public class InsertUserQuery {
    public void doQuery() throws Exception {
        String id;
        String password;
        String userName;

        String query="insert INTO User (ID,Password,name) VALUES(?,?,?)";
        loginloops:for(;;){
            System.out.println("아이디를 입력해주세요:");
            Scanner scanner1 = new Scanner(System.in);
            id=scanner1.nextLine();
            if (memberCheck(id)==0){
                break loginloops;
            }
            else{
                System.out.println("중복된 아이디 입니다. 다시 입력해주세요");
            }
        }

        Connection connection = DatabaseAcessObject.getConnection();
        System.out.println("비밀번호를 입력하세요: ");
        Scanner scanner2 = new Scanner(System.in);
        password=scanner2.nextLine();


        System.out.println("사용자이름을 입력하세요: ");
        Scanner scanner3 =new Scanner(System.in);
        userName=scanner3.nextLine();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,userName);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
