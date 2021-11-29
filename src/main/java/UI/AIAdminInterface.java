package UI;

import java.util.Scanner;
import AI.*;

public class AIAdminInterface implements UI{
    @Override
    public void showInterface() throws Exception {
        int select=0;
        while (select!=2){
            System.out.println("1:정확도 그래프 보이기");
            System.out.println("2프로그램 종료");
            Scanner scanner = new Scanner(System.in);
            select= scanner.nextInt();
            switch (select){
                case 1:
                    StockPrediction.runAI(2);
                    break;
                case 2:
                    break;
            }
        }
    }
}
