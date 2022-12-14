package pl.agh.edu.dp.decorators.border;

import pl.agh.edu.dp.Shape;
import pl.agh.edu.dp.decorators.BasedDecorator;
import java.awt.*;

public class DashedBorderDecorator  extends BasedDecorator {
    private final BasicStroke dashed = new BasicStroke(3,
            BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_ROUND,
            10.0f, new float[] {15.0f}, 0.0f);

    public DashedBorderDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(dashed);
        shape.draw(g);
    }
}