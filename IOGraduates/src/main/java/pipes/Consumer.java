package pipes;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author aburghelea
 * @since 5/8/2014
 */
public class Consumer implements Runnable {

    private PipedInputStream pipedInputStream;

    public Consumer(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int v = pipedInputStream.read();
                System.out.println("C:" + v + " ");
                Thread.sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
