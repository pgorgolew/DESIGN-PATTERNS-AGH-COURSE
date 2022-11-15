package pl.agh.edu.dp.decorators.border;
import pl.agh.edu.dp.Shape;
import pl.agh.edu.dp.decorators.BasedDecorator;


public enum EnumBorderDecorator {
    SOLID,
    DOTTED,
    DASHED;

    public BasedDecorator getBorderDecorator(String border, Shape shape) {
        return switch (valueOf(border)) {
            case SOLID -> new SolidBorderDecorator(shape);
            case DOTTED -> new DottedBorderDecorator(shape);
            case DASHED -> new DashedBorderDecorator(shape);
        };
    }
}
