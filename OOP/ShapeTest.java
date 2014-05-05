package oop;

/**
 * Created by ccatana on 4/30/2014.
 */
public class ShapeTest {
    private static Shape c = new Circle();
    private static Shape t = new Triangle();
    private static Shape rec = new Rectangle();

    public static void computeShapeArea(Shape shape){
        shape.computeArea();
    }

    public static void main(String[] args) {
        ((Circle)c).setRadius(10);
        ((Triangle)t).setLaturi(3, 4, 5);
        ((Rectangle)rec).setHigh(5);
        ((Rectangle)rec).setLength(10);

        c.helloWorld();
        t.helloWorld();
        rec.helloWorld();

        computeShapeArea(c);
        computeShapeArea(t);
        computeShapeArea(rec);
    }
}
