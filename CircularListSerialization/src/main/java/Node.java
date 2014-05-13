import java.io.Serializable;

/**
 * Created by ccatana on 5/13/2014.
 */
public class Node implements Serializable {
   static private int numere = 0;

    int data;

    Node previousNode;
    Node nextNode;

    Node(int data){

        this.data = data;
        numere++;

    }

}
