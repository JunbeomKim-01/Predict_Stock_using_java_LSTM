package DatabaseQuery.Querys.InsertQuery;

import Database.DatabaseAcessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStockCodeQuery {
    public void doQuery() throws SQLException {
        String query="INSERT INTO StockCode (NAME,CODE) VALUES(?,?)";
        System.out.println("추가할 주식 종목 이름을 입력하시오");
        Scanner scanner = new Scanner(System.in);
        String stockName=scanner.nextLine();
        System.out.println("추가할 주식의 코드를 입력하시오");
        Scanner scanner1 = new Scanner(System.in);
        String stockCode= scanner1.nextLine();

        Connection connection = DatabaseAcessObject.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,stockName );
        preparedStatement.setString(2,stockCode);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
