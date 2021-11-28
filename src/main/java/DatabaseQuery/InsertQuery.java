package DatabaseQuery;

import Database.DatabaseAcessObject;
import Storage.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static Login.LoginControll.memberCheck;

public class InsertQuery implements Query{
    @Override
    public void doQuery(String name,String patch) throws Exception {
        String query;
        if(name == "User"){//회원 가입
            String id;
            String password;
            String userName;

            query="insert INTO User (ID,Password,name) VALUES(?,?,?)";
            loginloops:for(;;){
                System.out.println("아이디를 입력해주세요:");
                Scanner scanner1 = new Scanner(System.in);
                id=scanner1.nextLine();
                if (memberCheck(id)==0){
                    break loginloops;
                }
                else{
                    System.out.println("중복된 아이디 입니다. 다시 입력해주세요");
                }
            }

            Connection connection = DatabaseAcessObject.getConnection();
            System.out.println("비밀번호를 입력하세요: ");
            Scanner scanner2 = new Scanner(System.in);
            password=scanner2.nextLine();


            System.out.println("사용자이름을 입력하세요: ");
            Scanner scanner3 =new Scanner(System.in);
            userName=scanner3.nextLine();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,userName);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        else if(name =="StockCode"){//주식 종목 추가
            query="INSERT INTO StockCode (NAME,CODE) VALUES(?,?)";
            System.out.println("추가할 주식 종목 이름을 입력하시오");
            Scanner scanner = new Scanner(System.in);
            String stockName=scanner.nextLine();
            System.out.println("추가할 주식의 코드를 입력하시오");
            Scanner scanner1 = new Scanner(System.in);
            String stockCode= scanner1.nextLine();

            Connection connection = DatabaseAcessObject.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,stockName );
            preparedStatement.setString(2,stockCode);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else if(name=="UserInfo"){//포트폴리오 추가
            // UserInfoDB에( ID,NAME,MONEY )INSERT
            // 현재 날짜 구하기
            LocalDate now = LocalDate.now();
            // 포맷 정의
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            // 포맷 적용
            String formatedNow = now.format(formatter);



            String querys="INSERT INTO UserInfo (ID,STOCK,MONEY,DATE) VALUES(?,?,?,?) ";
            Connection connection = DatabaseAcessObject.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(querys);
            preparedStatement.setString(1, Storage.getIteam("ID"));
            preparedStatement.setString(2, Storage.getIteam("STOCKNAME"));
            preparedStatement.setString(3, Storage.getIteam("PAY"));
            preparedStatement.setString(4, formatedNow);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }




    };
}
