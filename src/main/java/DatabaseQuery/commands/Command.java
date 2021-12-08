package DatabaseQuery.commands;

import java.sql.SQLException;

public interface Command {
    public abstract void excute() throws Exception;
}
