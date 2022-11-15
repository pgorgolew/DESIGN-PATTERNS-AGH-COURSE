package pl.agh.edu.dp.shapes;

import pl.agh.edu.dp.Shape;

import java.awt.*;

public abstract class BaseShape implements Shape {
    protected float width;
    protected float height;
    protected double marginWidth;
    protected  double marginHeight;
    public void setParams(int width, int height) {
        this.width = width;
        this.height = height;
        this.marginWidth = 0.2 * width;
        this.marginHeight = 0.2 * height;
    }

    @Override
    public void draw(Graphics g) {
    }
}
