package DatabaseQuery.commands.SelectCommand;

import DatabaseQuery.Querys.SelectQuery.SelectStockCodeQuery;
import DatabaseQuery.commands.Command;

import java.sql.SQLException;

public class SelectStockCodeCommand implements Command {
    private SelectStockCodeQuery selectStockCodeQuery;
    public SelectStockCodeCommand(SelectStockCodeQuery selectStockCodeQuery){
        this.selectStockCodeQuery = selectStockCodeQuery;
    }
    @Override
    public void excute() throws SQLException {
        selectStockCodeQuery.doQuery();
    }
}
