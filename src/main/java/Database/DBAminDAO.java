package Database;

import DatabaseQuery.Context;
import DatabaseQuery.SelecQuery;
import Storage.Storage;
import org.bytedeco.librealsense.context;
import org.bytedeco.opencv.opencv_stitching.Stitcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAminDAO extends DatabaseAcessObject {
    static Connection connection;
    public static int login() throws SQLException {
        String query= "SELECT Password From Admin Where Id=?";
        connection =DatabaseAcessObject.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1,Storage.getIteam("ID"));
        ResultSet row= preparedStatement.executeQuery();

        if(row.next()){
            if(row.getString(1).contentEquals(Storage.getIteam("PASSWORD"))){
                System.out.println("[DB-Admin 인증에 성공하였습니다.]");
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
                        query.toUpperCase().startsWith("INSERT") ||
                        query.toUpperCase().startsWith("DELETE") ||
                        query.toUpperCase().startsWith("UPDATE")
        );
    }

}


//알고리즘 바꿈-> 전랴패턴