package DatabaseQuery.Querys.DeleteQuery;

import Database.DatabaseAcessObject;
import clearScreen.clearScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUserQuery {
    public void doQuery() throws SQLException {
        String query="DELETE FROM User WHERE ID=?";
        clearScreen.clear();
        System.out.println("삭제할 유저 이름을 입력하시오");
        Scanner scanner = new Scanner(System.in);

        Connection connection = DatabaseAcessObject.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, scanner.nextLine());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("[삭제가 완료되었습니다]");
    }
}
