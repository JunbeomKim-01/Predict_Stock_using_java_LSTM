package Stock;
import AI.StockPrediction;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import DatabaseQuery.QueryCommandController;
import Storage.*;
import clearScreen.*;


public class StockMenu implements Menu{
    ArrayList<ArrayList<String>> menuList= new ArrayList<>();
    String query;
    public void selectMenu() throws Exception {
        QueryCommandController queryCommandController = QueryCommandController.getQueryController();
        queryCommandController.selectStockCode();
        System.out.println("원하시는 종목을 고르시오");
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        ArrayList<String> list = menuList.get(0);
        Storage.setStockName(list.get(select-1));//주식 이름 저장-> 저장된 주식이름으로 주식코드 설정(크롤링이 불법적인 관계로 흉내만 내봤습니다)
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
            //TODO <- 이부분도 프로토타입으로 주식종목
            QueryCommandController queryCommandController = QueryCommandController.getQueryController();
            queryCommandController.selectStockCode();
            menuList= Storage.getStockMenu();
            int index=1;
            clearScreen.clear();
            System.out.println("[상장된 종목]");
            for(ArrayList<String> a : menuList){
                for(String list :a){
                    System.out.println(index+": "+list);
                    index++;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}
