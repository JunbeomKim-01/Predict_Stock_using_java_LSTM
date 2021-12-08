package Database.Management;

import Database.DatabaseAcessObject;

import DatabaseQuery.QueryCommandController;

public class StockManagement
{
    QueryCommandController queryCommandController;
    public StockManagement(int select) throws Exception {
        queryCommandController = QueryCommandController.getQueryController();
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
        queryCommandController.insertStockCode();
    }
    void deletStock() throws Exception {
        //TODO <- 이부분 주석 지워야함
//        queryCommandController.setQuery(new DeletQuery());
//        queryCommandController.query("StockCode",null);
        queryCommandController.deleteStockCode();
    }
}
