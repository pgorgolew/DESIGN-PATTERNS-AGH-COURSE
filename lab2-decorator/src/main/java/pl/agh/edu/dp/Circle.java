package pl.agh.edu.dp;

public class Circle implements Shape{
    public Circle(String shapeName) {
        System.out.println("SHAPE " + shapeName + " constructor");
    }

    @Override
    public void draw() {
        System.out.println("Circle draw.");
    }
}
