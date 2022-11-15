package pl.agh.edu.dp.decorators.color;

import pl.agh.edu.dp.Shape;

public enum EnumColorsDecorators {
    RED,
    BLUE,
    GREEN;

    public static Shape getColorDecorator(String color, Shape shape) {
        return switch (valueOf(color.toUpperCase())) {
            case RED -> new RedColorDecorator(shape);
            case BLUE -> new BlueColorDecorator(shape);
            case GREEN -> new GreenColorDecorator(shape);
        };
    }
}