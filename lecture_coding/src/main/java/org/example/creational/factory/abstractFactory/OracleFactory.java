package org.example.creational.factory.abstractFactory;

import org.example.creational.factory.easy.Database;

public class OracleFactory implements DatabaseFactory{
    @Override
    public Connection createConnection() {
        return null;
    }

    @Override
    public Statement createStatement() {
        return null;
    }

    @Override
    public Commit createCommit() {
        return null;
    }

    @Override
    public Database execute(String statement) {
        return null;
    }
}
