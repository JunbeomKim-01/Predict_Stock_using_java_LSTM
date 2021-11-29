package Stock;

import DatabaseQuery.Context;
import DatabaseQuery.InsertQuery;
import DatabaseQuery.SelecQuery;
import Storage.Storage;
import clearScreen.*;
import java.util.ArrayList;

public class Portfolio implements Menu{
    @Override
    public void showMenu() throws Exception {
        Context context = new Context(new SelecQuery());
        context.excuteQuery("Table","UserInfo");
        ArrayList<ArrayList<String>> result =Storage.getSelectResult();

        clearScreen.clear();
        System.out.println("[현재 "+Storage.getIteam("ID")+"님의 포트폴리오]");
      for(ArrayList<String> sub: result){
          for (int i=0;i< sub.size();i=i+3){
              System.out.println("["+sub.get(i+2)+" "+sub.get(i)+" "+sub.get(i+1)+"주]");
          }
      }

    }
    void setPortfolio() throws Exception {// UserInfoDB에( ID,NAME,MONEY )INSERT
        Context context = new Context(new InsertQuery());
        context.excuteQuery("UserInfo",null);
    }
}
