package DatabaseQuery;

import java.sql.SQLException;

public interface Query {
    public abstract void doQuery(String query,String patch) throws Exception;
}
