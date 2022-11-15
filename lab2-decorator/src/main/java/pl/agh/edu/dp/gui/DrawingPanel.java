package pl.agh.edu.dp.gui;

import pl.agh.edu.dp.Shape;
import pl.agh.edu.dp.decorators.border.EnumBorderDecorator;
import pl.agh.edu.dp.decorators.color.EnumColorsDecorators;
import pl.agh.edu.dp.shapes.BaseShape;
import pl.agh.edu.dp.shapes.EnumShapes;

import javax.swing.*;
import pl.agh.edu.dp.shapes.BaseShape;

import java.awt.Graphics;

public class DrawingPanel extends JPanel {
    private String chosenColor = null;
    private String chosenShape = null;
    private String chosenBorder = null;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BaseShape baseShape = EnumShapes.getShape(chosenShape);
        baseShape.setParams(getWidth(), getHeight());

        Shape shape = baseShape;
        shape = EnumBorderDecorator.getBorderDecorator(chosenBorder, shape);
        shape = EnumColorsDecorators.getColorDecorator(chosenColor, shape);

        shape.draw(g);
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
