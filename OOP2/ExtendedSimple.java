package oop2;

/**
 * Created by ccatana on 4/30/2014.
 */
public class ExtendedSimple extends Simple {


    ExtendedSimple(){
        System.out.println("Hello World from 0-arg constructor");
    }
    ExtendedSimple(int i) {
        super(i);
        System.out.println("Hello World from 1-arg constructor");
    }
    ExtendedSimple(int i,int j){
        super(i);
        System.out.println("Hello World from 2-arg constructor");
    }

    public static void main(String[] args) {
    Simple s= new ExtendedSimple();
    Simple ss = new ExtendedSimple(1);
    Simple sss = new ExtendedSimple(1,2);
    }
}
