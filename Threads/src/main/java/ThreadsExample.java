import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ccatana on 5/13/2014.
 */
public class ThreadsExample {
    private static int[] lista = new int[10];
    private static Random random = new Random();


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            lista[i] = random.nextInt(10);
        }
        for(int i=0;i<10;i++){
            System.out.println(lista[i]);
        }
        System.out.println();
        Thread t1 = new Thread(new ThreadListaNoua(lista));
        t1.start();
    }
}
