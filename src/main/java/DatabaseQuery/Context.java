package DatabaseQuery;

import java.sql.SQLException;

public class Context{
    private Query query;

    public Context(Query query){ //해당 객체를 설정
        this.query=query;
    }

    public void excuteQuery(String name,String patch) throws Exception { // 해당 객체의 doQuery을 실행
        query.doQuery(name,patch);
    }
}
