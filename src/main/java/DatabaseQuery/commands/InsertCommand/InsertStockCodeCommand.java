package DatabaseQuery.commands.InsertCommand;

import DatabaseQuery.Querys.InsertQuery.InsertStockCodeQuery;
import DatabaseQuery.commands.Command;

import java.sql.SQLException;

public class InsertStockCodeCommand implements Command {
    private InsertStockCodeQuery insertStockCodeQuery;
    public InsertStockCodeCommand(InsertStockCodeQuery insertStockCodeQuery){
        this.insertStockCodeQuery=insertStockCodeQuery;
    }
    @Override
    public void excute() throws Exception {
        insertStockCodeQuery.doQuery();
    }
}
