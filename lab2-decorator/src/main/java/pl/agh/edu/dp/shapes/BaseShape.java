package pl.agh.edu.dp.shapes;

import pl.agh.edu.dp.Shape;

import java.awt.*;

public abstract class BaseShape implements Shape {
    protected int width;
    protected int height;

    public void setParams(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
    }
}
