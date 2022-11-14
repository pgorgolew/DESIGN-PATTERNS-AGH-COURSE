package pl.agh.edu.dp;

public class ColorDecorator extends BasedDecorator{
    public ColorDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        System.out.println("It's color decorator");
        this.shape.draw();
    }


}
