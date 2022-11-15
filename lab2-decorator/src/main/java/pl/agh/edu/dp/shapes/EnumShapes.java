package pl.agh.edu.dp.shapes;

public enum EnumShapes {
    CIRCLE,
    RECTANGLE,
    TRIANGLE;

    public static BaseShape getShape(String shape) {
        return switch (valueOf(shape.toUpperCase())) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case TRIANGLE -> new Triangle();
        };
    }
}
