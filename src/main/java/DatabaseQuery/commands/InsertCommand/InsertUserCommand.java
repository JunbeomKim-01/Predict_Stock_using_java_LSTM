package DatabaseQuery.commands.InsertCommand;

import DatabaseQuery.Querys.InsertQuery.InsertUserQuery;
import DatabaseQuery.commands.Command;

import java.sql.SQLException;

public class InsertUserCommand implements Command {
    private InsertUserQuery insertUserQuery;
    public InsertUserCommand(InsertUserQuery insertUserQuery){
        this.insertUserQuery=insertUserQuery;
    }
    @Override
    public void excute() throws Exception {
        insertUserQuery.doQuery();
    }
}
