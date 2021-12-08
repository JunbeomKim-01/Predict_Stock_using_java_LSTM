package Storage;

import org.bytedeco.opencv.opencv_stitching.Stitcher;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Storage {
    private static Storage storage;
    private static String nameStorage;
    private static String IDStorage;
    private static String passwordStorage;
    private static String codeStorage="005930";
    private static String stockNameStorage;
    private static String stockPayment;
    private static ArrayList<ArrayList<String>> portfolio= new ArrayList<>();
    private static ResultSet resultSet;
    private static ArrayList<ArrayList<String>> stockMenu= new ArrayList<>();

    public static void makeStorage(){
        storage =new Storage();
    }
    public static void setStockMenu(ArrayList<ArrayList<String>>list){
        stockMenu=list;
    }
    public static ArrayList<ArrayList<String>> getStockMenu(){return stockMenu;}
    public static void setId(String name){
        IDStorage=name;
    }
    public static void setName(String name){
        nameStorage=name;
    }
    public static void setPassword(String name){
        passwordStorage=name;
    }
    public static void setCode(String code){
        codeStorage= code;
    }
    public static void setStockName(String stockName){
        stockNameStorage= stockName;
    }
    public static void setStockPayment(String  pay){stockPayment=pay;}
    public static void setPortfolio(ArrayList<ArrayList<String>> result){
        portfolio=result;
    }
    public static void setResultSet(ResultSet resultSet) {
        Storage.resultSet = resultSet;
    }
    public static ArrayList<ArrayList<String>> getPortfolio() {
        return portfolio;
    }
    public static ResultSet getResultSet() {
        return resultSet;
    }
    public static String getIteam(String select){
        switch (select){
            case "ID":
                return IDStorage;
            case "CODE":
                return codeStorage;
            case "STOCKNAME":
                return stockNameStorage;
            case "PASSWORD":
                return passwordStorage;
            case "NAME":
                return nameStorage;
            case "PAY":
                return stockPayment;
        }
        return null;
    }


}
