package DatabaseQuery.Querys.DeleteQuery;

import Database.DatabaseAcessObject;
import Stock.StockMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStockCodeQuery {
    public void doQuery() throws SQLException {
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
}
