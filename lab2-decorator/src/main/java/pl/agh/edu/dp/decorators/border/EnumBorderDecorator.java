package pl.agh.edu.dp.decorators.border;
import pl.agh.edu.dp.Shape;


public enum EnumBorderDecorator {
    SOLID,
    DOTTED,
    DASHED;

    public static Shape getBorderDecorator(String border, Shape shape) {
        return switch (valueOf(border.toUpperCase())) {
            case SOLID -> new SolidBorderDecorator(shape);
            case DOTTED -> new DottedBorderDecorator(shape);
            case DASHED -> new DashedBorderDecorator(shape);
        };
    }
}
