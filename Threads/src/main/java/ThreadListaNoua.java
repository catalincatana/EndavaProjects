import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ccatana on 5/13/2014.
 */
public class ThreadListaNoua implements Runnable {
    private int[] listaVeche = new int[10];
    private int[] listaNoua ;

    public ThreadListaNoua(int[] listaVeche){
        this.listaVeche = Arrays.copyOf(listaVeche,listaVeche.length);
        listaNoua = new int[10];
    }

    public static boolean isPrime(int numar){
        for (int i = 2; i < numar; i++) {
            if (numar % i == 0 && i != numar) return false;
        }
        return true;
    }

    @Override
    public void run() {
        int j=0;
        for (int i = 0; i<listaVeche.length; i++){
            if(isPrime(listaVeche[i])){
                listaNoua[j] = listaVeche[i];
                j++;
            }
        }
        System.out.println("Lista cu numere prime:");
        for(int i = 0; i<j; i++){
            System.out.println(listaNoua[i]);
        }
    }
}
