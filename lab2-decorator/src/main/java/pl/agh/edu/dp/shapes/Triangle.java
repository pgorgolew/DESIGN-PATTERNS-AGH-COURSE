package pl.agh.edu.dp.shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Triangle extends BaseShape {
    private int[] xPositions;
    private int[] yPositions;

    @Override
    public void setParams(int width, int height) {
        super.setParams(width, height);
        this.xPositions = new int[]{width / 2, (int) (width - marginWidth), (int) marginWidth};
        this.yPositions = new int[]{(int) marginHeight, (int) (height - marginHeight), (int) (height - marginHeight)};
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(new Polygon(xPositions, yPositions, 3));

        //border
        g2d.setColor(Color.BLACK);
        g2d.draw(new Polygon(xPositions, yPositions, 3));
    }
}