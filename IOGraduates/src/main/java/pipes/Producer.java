package pipes;

import java.io.*;
import java.util.Random;

/**
 * @author aburghelea
 * @since 5/8/2014
 */
public class Producer implements Runnable {

    private Random generator = new Random(10);

    private PipedOutputStream pipedOutputStrem;

    public Producer(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStrem = pipedOutputStream;
    }

    @Override
    public void run() {
        while(true) {
            try {
                int v = generator.nextInt(100);
                System.out.println("P: " + v);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pipedOutputStrem.write(v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
