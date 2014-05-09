package myTryOuts;

import java.io.Serializable;

/**
 * Created by ccatana on 5/9/2014.
 */
public class Subclasa extends Superclasa {
    public static void main(String[] args) {
        Superclasa copil = new Subclasa();

        /*Testez mostenirea serializarii*/
        if(copil instanceof Serializable)
            System.out.println("DA");
        else
            System.out.println("NU");


    }
}
