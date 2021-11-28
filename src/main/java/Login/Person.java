package Login;
import java.util.Scanner;
import Database.*;

abstract class Person<T extends DatabaseAcessObject>{
    protected T DAO;
    protected abstract void doCall();
    public void call(){
        this.doCall();
    }
}




