package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Database.DatabaseAcessObject;
import DatabaseQuery.Context;
import DatabaseQuery.InsertQuery;

public class LoginControll {

    static Connection con =DatabaseAcessObject.getConnection();

   public static Login call(int userInput) throws Exception {
        switch (userInput) {
            case 1:
                return new UserLogin();
            case 2:
                return new DBAdminLogin();
            case 3:
                return new AIAdminLogin();
        }
        return null;
    }

    public static int memberCheck(String id)throws Exception{
        String query="SELECT id FROM User Where id=?";
        try {
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setString(1,id);
            ResultSet row= preparedStatement.executeQuery();
            if(row.next()){// 중복된 아이디가 없을 경우
                 if(row.getString("Id").contentEquals(id)){
                     return 1;//비정상
                 }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return 0;
    }

    public static void createAccount()throws SQLException, Exception {//회원가입
        try{
            Context context = new Context(new InsertQuery());
            context.excuteQuery("User",null);

        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
}
