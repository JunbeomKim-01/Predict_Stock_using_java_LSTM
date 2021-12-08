package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseAcessObject;

import DatabaseQuery.QueryCommandController;

public class LoginControll {
    static Connection con =DatabaseAcessObject.getConnection();
    static QueryCommandController queryCommandController = QueryCommandController.getQueryController();
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
            queryCommandController.insertUser();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
