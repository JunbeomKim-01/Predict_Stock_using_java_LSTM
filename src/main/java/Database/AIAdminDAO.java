package Database;

import Login.UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AIAdminDAO extends DatabaseAcessObject{

    public static int login(String id, String pw) throws SQLException {
        String query= "SELECT Password From User Where Id=?";
        Connection connection =DatabaseAcessObject.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1,id);
        ResultSet row= preparedStatement.executeQuery();

        if(row.next()){
            if(row.getString(1).contentEquals(pw)){
                System.out.println("[Admin 인증에 성공하였습니다.]");
                return 1;//정상
            }
        }
        System.out.println("아이디 또는 비밀번호가 존재하지 않습니다.");
        return 0;//비정상
    }
    @Override
    protected boolean Authoirity(String query) {
        return (
                query.toUpperCase().startsWith("SELECT") ||
                        query.toUpperCase().startsWith("INSERT")
        );
    }
}
