import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ccatana on 5/13/2014.
 */
public class ThreadExampleChunk {
    private static List lista = new ArrayList();
    private static Random random = new Random();
    private static List listaNoua = new ArrayList();
    private static List<Thread> threaduri = new ArrayList<Thread>();

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            lista.add(i,random.nextInt(10));
        }
        for(int i=0;i<10;i++){
            System.out.println(lista.get(i));
        }
        System.out.println();

        Thread t1 = new Thread(new ThreadListaNouaChunk(lista,0,2,listaNoua));
        Thread t2 = new Thread(new ThreadListaNouaChunk(lista,2,6,listaNoua));
        Thread t3 = new Thread(new ThreadListaNouaChunk(lista,6,10,listaNoua));

            threaduri.add(0,t1);
            threaduri.add(1,t2);
            threaduri.add(2,t3);

        t1.start();
        t2.start();
        t3.start();

        for(Thread thred:threaduri){
            try {
                thred.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("lista noua(Dimensiune):"+listaNoua.size());

        for(int i=0;i<listaNoua.size();i++){
            System.out.println(listaNoua.get(i));
        }
    }
}
