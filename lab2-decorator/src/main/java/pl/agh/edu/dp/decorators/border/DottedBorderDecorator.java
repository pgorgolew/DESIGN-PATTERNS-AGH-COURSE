package pl.agh.edu.dp.decorators.border;

import pl.agh.edu.dp.Shape;
import pl.agh.edu.dp.decorators.BasedDecorator;

import java.awt.*;

public class DottedBorderDecorator extends BasedDecorator {
    private final BasicStroke dotted = new BasicStroke(1,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f, new float[] {1, 2}, 0);

    public DottedBorderDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(dotted);
        shape.draw(g);
    }
}