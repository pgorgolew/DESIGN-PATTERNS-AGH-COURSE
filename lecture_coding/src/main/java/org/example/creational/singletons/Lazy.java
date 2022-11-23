package org.example.creational.singletons;

public class Lazy {
    public static Lazy instance = null;

    private Lazy(){
    }

    public static Lazy getInstance(){
        if (instance == null)
            // hazard racing problem here. Only once should be initialized. Only for one thread apps
            instance = new Lazy();
        return instance;
    }
}
