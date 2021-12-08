package DatabaseQuery.commands.SelectCommand;

import DatabaseQuery.Querys.SelectQuery.SelectUserInfoQuery;
import DatabaseQuery.commands.Command;

import java.sql.SQLException;

public class SelectUserInfoCommand implements Command {
    private SelectUserInfoQuery selectUserInfoQuery;
    public SelectUserInfoCommand(SelectUserInfoQuery selectUserInfoQuery){
        this.selectUserInfoQuery=selectUserInfoQuery;
    }
    @Override
    public void excute() throws SQLException {
        this.selectUserInfoQuery.doQuery();
    }
}
