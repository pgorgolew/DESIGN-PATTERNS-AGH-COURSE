package example;

public interface QueryBuilder {
    void addTable(String table);

    void addColumn(String column);

    void addCondition(String condition);
    Query build();
}
