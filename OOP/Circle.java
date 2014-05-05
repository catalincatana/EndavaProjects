package oop;

/**
 * Created by ccatana on 4/30/2014.
 */
public class Circle extends Shape {
    private int r;

    public void setRadius(int radius){
        r=radius;
    }
    public int getRadius(){
        return r;
    }

    @Override
    public void computeArea() {
        System.out.println("Raza cercului este: "+ Math.PI * r * r);
    }

    @Override
    public void helloWorld() {
        super.helloWorld();
        System.out.println("Hello World from Circle");
    }
}
