package org.example.creational.factory.factorymethod;

public class Main {
    public static void main(String[] args) {
        DatabaseFactory db = new OracleFactory();
        db.executeStatement("insert");
    }
}
