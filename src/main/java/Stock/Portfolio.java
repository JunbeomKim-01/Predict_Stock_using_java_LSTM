package Stock;
import DatabaseQuery.QueryCommandController;
import Storage.Storage;
import clearScreen.*;
import java.util.ArrayList;

public class Portfolio implements Menu{
    QueryCommandController queryCommandController;
    public Portfolio(){
        queryCommandController = QueryCommandController.getQueryController();
    }
    @Override
    public void showMenu() throws Exception {
        queryCommandController.selectUserInfo();
        //TODO <- 상장된 주식 클론
        ArrayList<ArrayList<String>> result =Storage.getPortfolio();
        clearScreen.clear();
        System.out.println("[현재 "+Storage.getIteam("ID")+"님의 포트폴리오]");
      for(ArrayList<String> sub: result){
          for (int i=0;i< sub.size();i=i+3){
              System.out.println("["+sub.get(i+2)+" "+sub.get(i)+" "+sub.get(i+1)+"주]");
          }
      }

    }
    void setPortfolio() throws Exception {// UserInfoDB에( ID,NAME,MONEY )INSERT
        queryCommandController.insertUserInfo();
    }
}
