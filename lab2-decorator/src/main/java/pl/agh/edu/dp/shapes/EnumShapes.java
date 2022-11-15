package pl.agh.edu.dp.shapes;

import pl.agh.edu.dp.Shape;

public enum EnumShapes {
    CIRCLE,
    SQUARE,
    TRIANGLE;

    public static BaseShape getShape(String shape) {
        return switch (valueOf(shape.toUpperCase())) {
            case CIRCLE -> new Circle();
            case SQUARE -> new Square();
            case TRIANGLE -> new Triangle();
        };
    }
}
