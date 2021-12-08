package DatabaseQuery.commands.DeleteCommand;

import DatabaseQuery.Querys.DeleteQuery.DeleteUserQuery;
import DatabaseQuery.commands.Command;

import java.sql.SQLException;

public class DeleteUserCommand implements Command {
    private DeleteUserQuery deleteUserQuery;
    public DeleteUserCommand(DeleteUserQuery deleteUserQuery){
        this.deleteUserQuery=deleteUserQuery;
    }
    @Override
    public void excute() throws SQLException {
        deleteUserQuery.doQuery();
    }
}
