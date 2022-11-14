package pl.agh.edu.dp;

public class AppMain {
    public static void main(String[] args) {
        Shape shape = new ColorDecorator(new Circle("circle"));
        shape.draw();

        SwingExample exmpl = new SwingExample();
    }
}