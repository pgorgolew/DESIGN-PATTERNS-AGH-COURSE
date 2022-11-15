package pl.agh.edu.dp.gui;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private String chosenColor = null;
    private String chosenShape = null;
    private String chosenBorder = null;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

//        int[] x = new int[]{65, 122, 77, 20};
//        int[] y = new int[]{226, 258, 341, 310};
//        g.setColor(Color.RED);
//        g.drawPolygon(x, y, x.length);
    }

    public void setChosenColor(String chosenColor) {
        this.chosenColor = chosenColor;
    }

    public void setChosenShape(String chosenShape) {
        this.chosenShape = chosenShape;
    }

    public void setChosenBorder(String chosenBorder) {
        this.chosenBorder = chosenBorder;
    }
}
