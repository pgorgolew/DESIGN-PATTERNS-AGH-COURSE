package pl.agh.edu.dp.shapes;

import java.awt.*;

public class Triangle extends BaseShape {
    private int[] xPositions;
    private int[] yPositions;

    @Override
    public void setParams(int width, int height) {
        super.setParams(width, height);
        this.xPositions = new int[]{0, width, width / 2};
        this.yPositions = new int[]{0, height, height};
    }

    @Override
    public void draw(Graphics g) {
        g.fillPolygon(xPositions, yPositions, 3);
    }
}