package pl.agh.edu.dp.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends BaseShape {
    private double radius;
    @Override
    public void setParams(int width, int height) {
        super.setParams(width, height);
        this.radius = Math.min((this.width - 2 * marginWidth)/2, (this.height - 2 * marginHeight)/2);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(new Ellipse2D.Double(width / 2 - radius,
                height / 2 - radius,
                radius*2,
                radius*2));

        //border
        g2d.setColor(Color.BLACK);
        g2d.draw(new Ellipse2D.Double(width / 2 - radius,
                height / 2 - radius,
                radius*2,
                radius*2));

    }
}
