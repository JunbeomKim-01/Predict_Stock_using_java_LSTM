package Database.Management;

import Database.DatabaseAcessObject;
import DatabaseQuery.Context;
import DatabaseQuery.DeletQuery;
import DatabaseQuery.UpdateQuery;
import clearScreen.*;
import java.sql.SQLException;
import java.util.Scanner;

public class MamberManagemenet extends DatabaseAcessObject {
    public MamberManagemenet(int select) throws Exception {
        switch (select){
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
    void memberUpdate(String name) throws Exception {
        Context context = new Context(new UpdateQuery());
        context.excuteQuery("User",name);
    }

    @Override
    protected boolean Authoirity(String query) {
        return false;
    }
}
