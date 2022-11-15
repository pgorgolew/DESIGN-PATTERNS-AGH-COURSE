package pl.agh.edu.dp.decorators.border;

import pl.agh.edu.dp.Shape;
import pl.agh.edu.dp.decorators.BasedDecorator;

import java.awt.*;

public class SolidBorderDecorator extends BasedDecorator {
    private final BasicStroke solid = new BasicStroke(1,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER);
    public SolidBorderDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(solid);
        shape.draw(g);
    }
}
