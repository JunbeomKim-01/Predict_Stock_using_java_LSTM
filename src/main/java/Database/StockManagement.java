package Database;

import DatabaseQuery.Context;
import DatabaseQuery.DeletQuery;
import DatabaseQuery.InsertQuery;
import java.util.Scanner;
import java.sql.SQLException;
import clearScreen.*;

public class StockManagement extends DatabaseAcessObject
{
    public StockManagement() throws Exception {
        clearScreen.clear();
        System.out.println("1: 주식 종목 추가");
        System.out.println("2: 주식 종목 삭제");
        Scanner scanner= new Scanner(System.in);
        switch (scanner.nextInt()){
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
