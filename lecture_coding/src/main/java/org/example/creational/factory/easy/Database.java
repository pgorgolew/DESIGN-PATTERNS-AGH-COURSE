package org.example.creational.factory.easy;

public interface Database {
    void connect();
    void disconnect();
    void execute(String name);
}
