package org.example.creational.singletons;

public class Eager {
    public volatile static Eager instance = new Eager();

    private Eager() {
    }


    public static Eager getInstance(){
        return instance;
    }
}

// specific version for Java
// volatile -> syngał dla kompilatora, żeby nie próbował optymalizować (coś z dostępem do pamięci).
