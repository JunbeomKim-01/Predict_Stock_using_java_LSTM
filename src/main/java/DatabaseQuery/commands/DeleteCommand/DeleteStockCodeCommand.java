package DatabaseQuery.commands.DeleteCommand;

import DatabaseQuery.Querys.DeleteQuery.DeleteStockCodeQuery;
import DatabaseQuery.commands.Command;

import java.sql.SQLException;

public class DeleteStockCodeCommand implements Command {
    private DeleteStockCodeQuery deleteStockCodeQuery;
    public DeleteStockCodeCommand(DeleteStockCodeQuery deleteStockCodeQuery){
        this.deleteStockCodeQuery=deleteStockCodeQuery;
    }
    @Override
    public void excute() throws SQLException {
        deleteStockCodeQuery.doQuery();
    }
}
