package oop;

/**
 * Created by ccatana on 4/30/2014.
 */
public class Rectangle extends Shape {
    private int l,L;

    public void setHigh(int Hi){
        l=Hi;
    }
    public void setLength(int Len){
        L=Len;
    }

    public int getHigh(){
        return l;
    }
    public int getLength(){
        return L;
    }
    @Override
    public void computeArea() {
        System.out.println("Raza Dreptunghiului este:" + l*L);
    }

    @Override
    public void helloWorld() {
        super.helloWorld();
        System.out.println("Hello World from Rectangle");
    }


}
