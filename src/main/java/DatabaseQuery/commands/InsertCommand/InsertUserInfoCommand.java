package DatabaseQuery.commands.InsertCommand;

import DatabaseQuery.Querys.InsertQuery.InsertUserInfoQuery;
import DatabaseQuery.Querys.InsertQuery.InsertUserQuery;
import DatabaseQuery.commands.Command;

import java.sql.SQLException;

public class InsertUserInfoCommand implements Command {
    private InsertUserInfoQuery insertUserInfoQuery;
    public InsertUserInfoCommand(InsertUserInfoQuery insertUserInfoQuery){
        this.insertUserInfoQuery=insertUserInfoQuery;
    }
    @Override
    public void excute() throws SQLException {
        insertUserInfoQuery.doQuery();
    }
}
