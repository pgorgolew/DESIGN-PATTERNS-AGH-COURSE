package example;

public class Main {
    public static void main(String[] args) {
        QueryBuilder queryBuilder = new OracleQueryBuilder();

        queryBuilder.addTable("students");
        queryBuilder.addColumn("age");
        queryBuilder.addColumn("name");
        queryBuilder.addCondition("age > 26");

        Query query = queryBuilder.build();
        System.out.println(query.getSQL());
    }
}