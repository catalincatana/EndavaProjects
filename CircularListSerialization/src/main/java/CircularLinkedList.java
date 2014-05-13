import java.io.IOException;
import java.io.Serializable;

/**
 * Created by ccatana on 5/13/2014.
 */
public class CircularLinkedList implements Serializable {
    private Node root;
    private static Node temp;
    private static Node current;


    public void addNodes(int data) {

        Node dNode = new Node(data);
        //Daca lista este goala
        if (root == null) {
            root = dNode;
            root.previousNode = null;
            root.nextNode = null;
        } else {
            current = root;
            while (current.nextNode != null) {
                current = current.nextNode;
            }

            current.nextNode = dNode;
            dNode.previousNode = current;
            dNode.nextNode = null;
        }
    }


    public void deleteNode(int nodeNumber) {

        int ithNode = 1;
        current = root;
        if (nodeNumber == 1) {
            root = current.nextNode;
            current.nextNode = null;
            current.previousNode = null;
        } else {
            while (ithNode != nodeNumber) {
                current = current.nextNode;
                ithNode++;
            }
            if (current.nextNode == null) {
                current.previousNode.nextNode = null;
                current.previousNode = null;
            } else {
                current.previousNode.nextNode = current.nextNode;
                current.nextNode.previousNode = current.previousNode;
            }

        }
    }

    public void print() {

        current = root;
        boolean arrow = true;
        do {
            System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|" + current.data + "|");
            arrow = false;
            current = current.nextNode;
        } while (current != null);
        System.out.println();
    }

    public void printBackwards() {
        current = root;
        boolean arrow = true;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        do {
            System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|" + current.data + "|");
            arrow = false;
            current = current.previousNode;
        } while (current.previousNode != null);

        System.out.print(" --> " + "|" + current.data + "|");

    }

    public static void main(String[] args) {
        CircularLinkedList lista  = new CircularLinkedList();
        lista.addNodes(1);
        lista.addNodes(2);
        lista.addNodes(3);
        lista.addNodes(4);
        lista.addNodes(5);
        lista.addNodes(6);

      //  lista.print();
     //   System.out.println();
      //  lista.printBackwards();

        String fileName="lista.ser";

        //serialize to file
        try {
            Serialization.serialize(lista, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        CircularLinkedList listaRecreata = null;
        try {
            listaRecreata = (CircularLinkedList) Serialization.deserialize(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

       // System.out.println("Obiectul initial:"+lista);
      //  System.out.println("Obiectul deserializat:"+listaRecreata);

        System.out.println("Lista initiala:");
        lista.print();
        System.out.println("Lista reconstruita:");
        listaRecreata.print();
    }
}
