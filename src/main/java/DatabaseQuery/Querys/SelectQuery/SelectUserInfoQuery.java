package DatabaseQuery.Querys.SelectQuery;

import Database.DatabaseAcessObject;
import Storage.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectUserInfoQuery implements Cloneable{
    public void doQuery() throws SQLException {
        ArrayList<ArrayList<String>> result= new ArrayList<>();
        Connection connection = DatabaseAcessObject.getConnection();
        String query = "SELECT * FROM UserInfo WHERE ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, Storage.getIteam("ID"));
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> subsresult= new ArrayList<>();
        while (resultSet.next()) {
            subsresult.add(resultSet.getString("STOCK"));
            subsresult.add(resultSet.getString("MONEY"));
            subsresult.add(resultSet.getString("DATE"));
        }
        result.add(subsresult);
        Storage.setPortfolio(result);
    }
}
