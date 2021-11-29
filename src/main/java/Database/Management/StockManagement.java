package Database.Management;

import Database.DatabaseAcessObject;
import DatabaseQuery.Context;
import DatabaseQuery.DeletQuery;
import DatabaseQuery.InsertQuery;
import java.util.Scanner;
import java.sql.SQLException;
import clearScreen.*;

public class StockManagement extends DatabaseAcessObject
{
    public StockManagement(int select) throws Exception {
        switch (select){
            case 1:
                addStock();
                break;
            case 2:
                deletStock();
                break;
        }
    }

    void addStock() throws Exception {
        Context context = new Context(new InsertQuery());
        context.excuteQuery("StockCode",null);
    }
    void deletStock() throws Exception {
        Context context = new Context(new DeletQuery());
        context.excuteQuery("StockCode",null);

    }

    @Override
    protected boolean Authoirity(String query) {
        return false;
    }
}
