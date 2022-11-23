package org.example.creational.singletons;

public class Synchronized {
    public static Synchronized instance = null;

    private Synchronized(){
    }

    public static synchronized Synchronized getInstance(){
        if (instance == null)
            instance = new Synchronized();
        return instance;
    }
}