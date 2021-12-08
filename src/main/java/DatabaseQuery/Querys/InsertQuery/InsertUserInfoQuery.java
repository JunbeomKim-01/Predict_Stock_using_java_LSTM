package DatabaseQuery.Querys.InsertQuery;

import Database.DatabaseAcessObject;
import Storage.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsertUserInfoQuery {
    public void doQuery() throws SQLException {
        //포트폴리오 추가
        // UserInfoDB에( ID,NAME,MONEY )INSERT
        // 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // 포맷 적용
        String formatedNow = now.format(formatter);

        String querys="INSERT INTO UserInfo (ID,STOCK,MONEY,DATE) VALUES(?,?,?,?) ";
        Connection connection = DatabaseAcessObject.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(querys);
        preparedStatement.setString(1, Storage.getIteam("ID"));
        preparedStatement.setString(2, Storage.getIteam("STOCKNAME"));
        preparedStatement.setString(3, Storage.getIteam("PAY"));
        preparedStatement.setString(4, formatedNow);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
