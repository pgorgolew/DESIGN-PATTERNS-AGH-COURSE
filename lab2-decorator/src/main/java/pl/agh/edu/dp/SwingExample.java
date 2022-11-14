package pl.agh.edu.dp;
import javax.swing.*;

public class SwingExample extends JFrame {
    public SwingExample() {
        initUI();
    }

    private void initUI(){
        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Box box = Box.createHorizontalBox();
        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        JButton b2=new JButton("click2");//creating instance of JButton
        b2.setBounds(130,100,100, 40);//x axis, y axis, width, height

        box.add(b);//adding button in JFrame
        box.add(b2);//adding button in JFrame
        box.setVisible(true);
        this.add(box);

        this.setSize(400,500);//400 width and 500 height
        this.setLayout(null);//using no layout managers
        this.setVisible(true);//making the frame visible
    }
}