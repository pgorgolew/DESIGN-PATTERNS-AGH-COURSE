package example;

public class OracleQuery implements Query{
    private String query;

    public OracleQuery(String sql) {
        query = sql;
    }


    @Override
    public String getSQL() {
        return query;
    }
}
