package DatabaseQuery;

import Database.DatabaseAcessObject;
import Stock.StockMenu;
import Storage.Storage;
import clearScreen.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletQuery implements Query{

    public void doQuery(String name, String patch) throws SQLException {
       if ( name=="User"){
           String query="DELETE FROM User WHERE ID=?";
           clearScreen.clear();
           System.out.println("삭제할 유저 이름을 입력하시오");
           Scanner scanner = new Scanner(System.in);

           Connection connection = DatabaseAcessObject.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1, scanner.nextLine());
           preparedStatement.executeUpdate();
           preparedStatement.close();

           System.out.println("[삭제가 완료되었습니다. 프로그램은 자동으로 종료됩니다.]");
       }else {
           StockMenu stockMenu = new StockMenu();
           stockMenu.showMenu();
           System.out.println("삭제할 주식종목을 입력하시오");
           Scanner scanner = new Scanner(System.in);

           String query="DELETE FROM StockCode WHERE NAME=?";
           Connection connection = DatabaseAcessObject.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query);

           preparedStatement.setString(1, scanner.nextLine());
           preparedStatement.executeUpdate();
           preparedStatement.close();
       }

        //TODO
    }
}
