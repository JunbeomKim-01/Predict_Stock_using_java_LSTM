package Database;

import org.junit.runner.Request;
import org.sqlite.SQLiteConfig;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class DatabaseAcessObject {
    private static Connection connection;
    public static int connectDatabase() throws SQLException{
        System.out.println("[데이터베이스 연결]");
    try {
        if (connection==null){
            /*
            IDE로 실행시 주석처리된 코드를 사용하시기 바랍니다.
            Path paths = Paths.get("Userdatabase.db");
            String nowPath= paths.toAbsolutePath().toString();
            */
            //아래는 JAR전용코드 입니다.
            System.out.print("[UserDatabase.db 파일을 이곳에 드래그해주세요]:");
            Scanner scanner = new Scanner(System.in);

            String nowPath = scanner.next();
            connection= DriverManager.getConnection("jdbc:sqlite:"+nowPath);
        }
        return 1;
    } catch (SQLException e){
        System.out.println("[연결 실패]");
        System.out.println(e.getMessage());
    }
    return 0;
    }
    public static Connection getConnection(){
        return connection;
    }
    public static void closeDatabase()throws SQLException{
        System.out.println("[데이터베이스 연결 해제]");
        try{
            if (connection!=null){
                if (!connection.isClosed()){
                    connection.close();
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

