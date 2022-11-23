package org.example.creational.factory.factorymethod;

import org.example.creational.factory.easy.Database;
import org.example.creational.factory.easy.OracleDB;

public class OracleFactory extends DatabaseFactory {
    @Override
    public Database createConnection() {
        return new OracleDB();
    }
}
