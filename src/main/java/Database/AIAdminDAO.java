package Database;

import Storage.Storage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AIAdminDAO{
    public static int login() throws SQLException {
        String query= "SELECT Password From AIAdmin Where Id=?";
        Connection connection =DatabaseAcessObject.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1,Storage.getIteam("ID"));
        ResultSet row= preparedStatement.executeQuery();

        if(row.next()){
            if(row.getString(1).contentEquals(Storage.getIteam("PASSWORD"))){
                System.out.println("[Admin 인증에 성공하였습니다.]");
                return 1;//정상
            }
        }
        System.out.println("아이디 또는 비밀번호가 존재하지 않습니다.");
        return 0;//비정상
    }
}
