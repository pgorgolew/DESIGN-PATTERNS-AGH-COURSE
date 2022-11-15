package pl.agh.edu.dp.shapes;

import pl.agh.edu.dp.Shape;

public enum EnumShapes {
    CIRCLE,
    SQUARE,
    TRIANGLE;

    public Shape getShape(String shape) {
        return switch (valueOf(shape)) {
            case CIRCLE -> new Circle();
            case SQUARE -> new Square();
            case TRIANGLE -> new Triangle();
        };
    }
}
