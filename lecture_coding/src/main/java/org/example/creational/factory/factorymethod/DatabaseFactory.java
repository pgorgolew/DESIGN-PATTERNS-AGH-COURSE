package org.example.creational.factory.factorymethod;

import org.example.creational.factory.easy.Database;

public abstract class DatabaseFactory {
    public Database executeStatement(String statement){
        return createConnection();
    }

    public abstract Database createConnection();
}
