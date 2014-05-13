
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ccatana on 5/13/2014.
 */
public class ThreadListaNouaChunk implements Runnable {
    private List bucataLista = new ArrayList();
    private List listaNoua = new ArrayList() ;
    private int start;
    private int stop;

    public ThreadListaNouaChunk(List listaVeche, int start, int end, List listaNoua){
        /*for(int i=start; i<end ;i++) {
            bucataLista.add(i,listaVeche.get(i));
        }*/
        this.bucataLista = listaVeche;
        this.listaNoua = listaNoua;
        this.start = start;
        this.stop = end;
        //listaNoua = new int[bucataLista.length];
    }

    public static boolean isPrime(int numar){
        for (int i = 2; i < numar; i++) {
            if (numar % i == 0 && i != numar) return false;
        }
        return true;
    }

    @Override
    public void run() {
       // int j=0;
        for (int i = start; i<stop; i++){
            //Integer valoare = (Integer)bucataLista.get(i);
          //  System.out.println("Valoareee:"+valoare);
            if(isPrime(((Integer) bucataLista.get(i)))){
              //  System.out.println("e prim");
                synchronized (listaNoua) {
                    listaNoua.add(bucataLista.get(i));
                   // j++;
                 //   System.out.println("Scrie in bucata lista");
                }
            }
        }
        System.out.println("a rulat");
    }
}
