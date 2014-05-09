package pipes;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author aburghelea
 * @since 5/8/2014
 */
public class Main {

    public static void main(String[] argv) throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        Thread producer = new Thread(new Producer(pipedOutputStream));
        Thread consumer = new Thread(new Consumer(pipedInputStream));

        producer.start();
        consumer.start();

    }

}
