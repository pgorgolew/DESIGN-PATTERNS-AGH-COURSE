package pl.agh.edu.dp.gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private final JComboBox<String> shapeBox = new JComboBox<>(new String[] {"Circle", "Triangle", "Rectangle"});
    private final JComboBox<String> colorBox = new JComboBox<>(new String[] {"Red", "Blue", "Green"});
    private final JComboBox<String> borderBox = new JComboBox<>(new String[] {"Solid", "Dotted", "Dashed"});
    private final DrawingPanel drawingPanel = new DrawingPanel();

    public MainFrame() {
        createUIComponents();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setButtonsListeners();
    }

    private void setButtonsListeners() {
        shapeBox.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            drawingPanel.setChosenShape((String)cb.getSelectedItem());
            repaint();
        });

        colorBox.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            drawingPanel.setChosenColor((String)cb.getSelectedItem());
            repaint();
        });

        borderBox.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            drawingPanel.setChosenBorder((String)cb.getSelectedItem());
            repaint();
        });
    }

    private void createUIComponents() {
        Box buttonsBox = Box.createVerticalBox();
        buttonsBox.add(shapeBox);
        buttonsBox.add(borderBox);
        buttonsBox.add(colorBox);

        Box mainHBox = Box.createHorizontalBox();
        mainHBox.add(buttonsBox);
        mainHBox.add(drawingPanel);

        mainHBox.setAlignmentX(CENTER_ALIGNMENT);
        mainHBox.setAlignmentY(CENTER_ALIGNMENT);
        add(mainHBox);

        drawingPanel.setChosenColor((String) colorBox.getSelectedItem());
        drawingPanel.setChosenShape((String) shapeBox.getSelectedItem());
        drawingPanel.setChosenBorder((String) borderBox.getSelectedItem());
    }
}
