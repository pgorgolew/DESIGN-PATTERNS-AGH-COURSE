package pl.agh.edu.dp.decorators.color;

import pl.agh.edu.dp.Shape;
import pl.agh.edu.dp.decorators.BasedDecorator;

import java.awt.*;

public class RedColorDecorator extends BasedDecorator {
    public RedColorDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
    }
}
