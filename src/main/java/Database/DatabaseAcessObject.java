package Database;
import java.io.File;
import java.sql.*;

abstract public class DatabaseAcessObject {
    private static Connection connection;

    public static Connection connectDatabase() throws SQLException{
        System.out.println("[데이터베이스 연결]");
    try {
        if (connection==null){
            String dbFile= "../../java_project/UserDatabase.db";//상대경로
            connection= DriverManager.getConnection("jdbc:sqlite:"+dbFile);
        }
        return connection;
    } catch (SQLException e){
        System.out.println("[연결 실패]");
        System.out.println(e.getMessage());
    }
    return null;
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
            System.out.println(e);
        }
    }

    protected abstract boolean Authoirity(String query);

    public String Exception(String query) {
        if (this.Authoirity(query) == false) return "Authority Error";
        return "ture";
    }
}

