package org.example.creational.factory.abstractFactory;

public class Main {
    public static void main(String[] args) {
        DatabaseStatement statement = new OracleStatement(new OracleFactory());
        statement.execute("insert");
    }
}
