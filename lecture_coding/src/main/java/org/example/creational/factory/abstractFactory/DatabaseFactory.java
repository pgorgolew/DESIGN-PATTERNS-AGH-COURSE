package org.example.creational.factory.abstractFactory;

import org.example.creational.factory.easy.Database;

public interface DatabaseFactory {
    Connection createConnection();
    Statement createStatement();
    Commit createCommit();
    Database execute(String statement);
}
