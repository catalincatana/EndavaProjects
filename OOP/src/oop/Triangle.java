package oop;

/**
 * Created by ccatana on 4/30/2014.
 */
public class Triangle extends Shape {
    private int a,b,c,p;

    public void setLaturi(int aa,int bb,int cc){
        a=aa;
        b=bb;
        c=cc;
    }
    public String getLaturi(){
        return " " +a+ " "+b+" "+c+"";
    }
    @Override
    public void computeArea() {
        p=(a+b+c)/2;
        System.out.println("Raza triunghiului(HERON) este: " + Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }

    @Override
    public void helloWorld() {
        super.helloWorld();
        System.out.println("Hello World from Triangle");
    }
}
