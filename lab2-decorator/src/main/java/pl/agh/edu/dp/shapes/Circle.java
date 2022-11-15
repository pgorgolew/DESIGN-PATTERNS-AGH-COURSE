package pl.agh.edu.dp.shapes;

import java.awt.*;

public class Circle extends BaseShape {
    private int radius;
    @Override
    public void setParams(int width, int height) {
        super.setParams(width, height);
        this.radius = Math.min(width/5, height/5);
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(width/2-radius, height/2-radius, radius*2, radius*2);
    }
}
