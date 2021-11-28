package Database;

import DatabaseQuery.Context;
import DatabaseQuery.DeletQuery;
import DatabaseQuery.UpdateQuery;
import clearScreen.*;
import java.sql.SQLException;
import java.util.Scanner;

public class MamberManagemenet extends DatabaseAcessObject{
    public MamberManagemenet() throws Exception {
        clearScreen.clear();
        //System.out.println("1: 회원 수정");
        System.out.println("1: 회원 삭제");
        Scanner scanner= new Scanner(System.in);

        switch (scanner.nextInt()){
//            case 1:
//                clearScreen.clear();
//                memberUpate("null");
//                break;
            case 1:
                clearScreen.clear();
                memberDeny("");
                break;
        }
    }
    void memberDeny(String name) throws Exception {
        Context context = new Context(new DeletQuery());
        context.excuteQuery("User",name);

    }
    void memberUpate(String name) throws Exception {
        Context context = new Context(new UpdateQuery());
        context.excuteQuery("User",name);
    }

    @Override
    protected boolean Authoirity(String query) {
        return false;
    }
}
