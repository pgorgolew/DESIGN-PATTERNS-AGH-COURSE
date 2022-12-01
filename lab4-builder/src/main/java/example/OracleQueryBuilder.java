package example;

import java.util.ArrayList;
import java.util.List;

public class OracleQueryBuilder implements QueryBuilder{
    private List<String> tables = new ArrayList<>();
    private List<String> columns = new ArrayList<>();
    private List<String> conditions = new ArrayList<>();

    @Override
    public void addTable(String table) {
        tables.add(table);
    }

    @Override
    public void addColumn(String column) {
        columns.add(column);
    }

    @Override
    public void addCondition(String condition) {
        conditions.add(condition);
    }

    @Override
    public Query build() {
        String sql = "select " + columns.toString() + " from " + tables.toString() + " where " + conditions.toString();
        return new OracleQuery(sql);
    }
}
