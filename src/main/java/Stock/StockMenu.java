package Stock;
import AI.StockPrediction;
import Database.DatabaseAcessObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Storage.*;
import clearScreen.*;
import Data.*;

public class StockMenu implements Menu{
    ArrayList<String> menuList= new ArrayList<>();
    String query;
    public void selectMenu(){
        System.out.println("원하시는 종목을 고르시오");
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        Crawling crawling = new Crawling();
        Storage.setStockName(menuList.get(select-1));//주식 이름 저장
        crawling.codeCrawling();// 저장된 주식이름으로 주식코드 설정
    }
    public void selectPrice() throws Exception {
       try{
           System.out.println("몇 주를 구매하시겠습니까?");
           Scanner scanner1 = new Scanner(System.in);
           Storage.setStockPayment(scanner1.nextLine());

           Portfolio portfolio = new Portfolio();
           portfolio.setPortfolio();

           StockPrediction.runAI(1);
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
   public void showMenu() {
        try {
            menuList= getMenu();
            int index=1;
            clearScreen.clear();
            System.out.println("[상장된 종목]");
            for(String list: menuList){
                System.out.println(index+": "+ list);
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
    ArrayList<String> getMenu() throws SQLException {
        query="SELECT * FROM StockCode ";
        Connection connection= DatabaseAcessObject.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            menuList.add(resultSet.getString("NAME"));
        }
        return menuList;
    }
}
