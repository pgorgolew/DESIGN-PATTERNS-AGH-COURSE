package pl.agh.edu.dp.shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends BaseShape {

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(new Rectangle2D.Double(
                marginWidth, marginHeight, width-2*marginWidth, height-2*marginHeight)
        );

        //border
        g2d.setColor(Color.BLACK);
        g2d.draw(new Rectangle2D.Double(
                marginWidth, marginHeight, width-2*marginWidth, height-2*marginHeight)
        );
    }
}
