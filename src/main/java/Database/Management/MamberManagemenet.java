package Database.Management;

import Database.DatabaseAcessObject;
import DatabaseQuery.QueryCommandController;
import clearScreen.*;

public class MamberManagemenet extends DatabaseAcessObject {
    QueryCommandController queryCommandController;
    public MamberManagemenet(int select) throws Exception {
        queryCommandController = QueryCommandController.getQueryController();
        switch (select){
            case 1:
                clearScreen.clear();
                memberDeny();
                break;
        }
    }
    void memberDeny() throws Exception {
        queryCommandController.deleteUser();

    }
}
