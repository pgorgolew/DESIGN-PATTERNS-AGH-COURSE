package org.example.creational.factory.easy;

public class Main {
    public static void main(String[] args) {
        Database db = EasyFactory.createDatabase(0);
        db.connect();
        db.execute("Something");
        db.disconnect();
    }
}
