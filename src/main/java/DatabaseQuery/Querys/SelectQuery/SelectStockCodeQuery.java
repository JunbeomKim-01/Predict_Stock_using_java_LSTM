package DatabaseQuery.Querys.SelectQuery;

import Database.DatabaseAcessObject;
import Storage.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStockCodeQuery implements Cloneable{
    public void doQuery() throws SQLException {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Connection connection = DatabaseAcessObject.getConnection();
        String query="SELECT * FROM STOCKCODE";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> subsresult= new ArrayList<>();
        while (resultSet.next()) {
            subsresult.add(resultSet.getString("NAME"));
        }
        result.add(subsresult);
        Storage.setStockMenu(result);
    }
}
