package DatabaseQuery;

import DatabaseQuery.commands.Command;
public class QueryCommandController {
    private static QueryCommandController queryCommandController = new QueryCommandController();
    private static Command selectUserInfoCommand;
    private static Command seletStockCodeCommand;
    private static Command insertUserCommand;
    private static Command insertUserInfoCommand;
    private static Command insertStockCodeCommand;
    private static Command deleteUserCommand;
    private static Command deleteStockCommand;

    public static void setCommand(Command selectUserInfo,Command seletStockCode,Command insertStockCode,Command insertUser,Command insertUserInfo, Command deleteStock,Command deleteUser){
    selectUserInfoCommand=selectUserInfo;
    seletStockCodeCommand=seletStockCode;
    insertStockCodeCommand=insertStockCode;
    insertUserInfoCommand=insertUserInfo;
    insertUserCommand= insertUser;
    deleteStockCommand=deleteStock;
    deleteUserCommand=deleteUser;
}
    public void selectUserInfo() throws Exception {
     selectUserInfoCommand.excute();
    }
    public void selectStockCode() throws Exception {
       seletStockCodeCommand.excute();
    }
    public void insertUser() throws Exception {
        insertUserCommand.excute();
    }
    public void insertUserInfo() throws Exception {
        insertUserInfoCommand.excute();
    }
    public void insertStockCode() throws Exception {
        insertStockCodeCommand.excute();
    }
    public void deleteUser() throws Exception {
        deleteUserCommand.excute();
    }
    public void deleteStockCode() throws Exception {
        deleteStockCommand.excute();
    }
    public static QueryCommandController getQueryController(){
       return queryCommandController;
    }

}
