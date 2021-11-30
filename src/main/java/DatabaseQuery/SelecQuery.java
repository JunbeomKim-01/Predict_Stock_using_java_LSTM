package DatabaseQuery;
import Database.*;
import Storage.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelecQuery implements Query{

    @Override
    public void doQuery(String query,String patch) throws SQLException {
      try {
          Connection connectio = DatabaseAcessObject.getConnection();
          if(query == "Name"){
              selectName(connectio,patch);
          }else if(query == "Table"){
              selectTable(connectio,patch);
          }
      }catch (SQLException e){
          e.printStackTrace();
      }
    }

    protected void selectTable(Connection connection,String tableName) throws SQLException {
        //투자 종목이나 포트폴리오 볼 때
        ArrayList<ArrayList<String>> result =new ArrayList<>();
        if(tableName=="StockCode"){
            String query="SELECT * FROM STOCKCODE";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<String> subsresult= new ArrayList<>();
            while (resultSet.next()) {
                subsresult.add(resultSet.getString("NAME"));
                //subsresult.add(resultSet.getString("MONEY"));
                result.add(subsresult);
            }
            Storage.setSelectResult(result);
        }
        else {
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
            Storage.setSelectResult(result);
        }
    }

    protected void selectName(Connection connection, String name) throws SQLException {
        String query="SELECT * FROM User WHERE ID=?";//회원 체크할 때

        PreparedStatement preparedStatement =connection.prepareStatement(query);
        preparedStatement.executeQuery();

        ResultSet resultSet= preparedStatement.executeQuery();
        preparedStatement.setString(1,name);
        resultSet.next();

        Storage.setResultSet(resultSet);
    }
}
