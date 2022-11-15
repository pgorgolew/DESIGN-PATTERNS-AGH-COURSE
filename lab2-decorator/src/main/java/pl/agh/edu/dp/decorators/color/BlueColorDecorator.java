package pl.agh.edu.dp.decorators.color;

import pl.agh.edu.dp.Shape;
import pl.agh.edu.dp.decorators.BasedDecorator;

import java.awt.*;

public class BlueColorDecorator extends BasedDecorator {
    public BlueColorDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
    }
}