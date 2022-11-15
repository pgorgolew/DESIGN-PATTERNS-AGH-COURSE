package pl.agh.edu.dp.shapes;

import pl.agh.edu.dp.Shape;

import java.awt.*;

public class Square extends BaseShape {

    @Override
    public void draw(Graphics g) {
        g.fillRect(0,0, width, height);
    }
}
