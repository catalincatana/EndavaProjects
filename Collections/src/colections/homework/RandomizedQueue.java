package colections.homework;

import java.util.*;

/**
 * Created by ccatana on 5/8/2014.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    List<Item> lista = new ArrayList<Item>();

    public Random random = new Random();

    // construct an empty randomized queue
    public RandomizedQueue(){}

    // is the queue empty?
    public boolean isEmpty(){
        if(lista.isEmpty())
            return true;
        else
            return false;
    }

    // return the number of items on the queue
    public int size(){
        return lista.size();
    }

    // add the item
    public void enqueue(Item item){
        try {
            lista.add(item);
        }
        catch (NullPointerException e){
            System.out.println("Nu aveti voie sa introduceti valori nule!");
        }
    }

    // delete and return a random item
    public Item dequeue(){
        try {
            return lista.remove(random.nextInt(lista.size()));
        }
        catch(NoSuchElementException nse){
            System.out.println("Nu exista elementul de sters");
        }
        return null;
    }

    // return (but do not delete) a random item
    public Item sample(){
        try {
            return lista.get(random.nextInt(lista.size()));
        }
        catch(NoSuchElementException nse){
            System.out.println("Nu exista elementul de returnat");
        }
        return null;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
    /*Prima varianta*/
        /*List<Item> shuffleList = new ArrayList<Item>(lista);
        Collections.shuffle(shuffleList);
        Iterator<Item> iteratorItem = shuffleList.iterator();
        return iteratorItem;*/

    /*Varianta cu next si has next*/
        return new IteratorClass();
    }

    // unit testing
    public static void main(String[] args){
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());

    /*Adaugam elemente in coada*/
        rq.enqueue(10);
        rq.enqueue(20);
        rq.enqueue(30);
        rq.enqueue(40);
        rq.enqueue(50);

        System.out.println("A sters:" + rq.dequeue());

    /*Sample*/
        System.out.println("Returnam random item:" + rq.sample());

        Iterator<Integer> iterator = rq.iterator();
        while(iterator.hasNext()){
            System.out.println("Un element este:" + iterator.next());
        }

    }

    class IteratorClass implements Iterator{
        int counter = 0;

        public IteratorClass()
        {
            Collections.shuffle(lista);
        }

        @Override
        public boolean hasNext(){
            while(counter < lista.size() )
                return true;

         return false;
        }

        @Override
        public Item next() {
            try{
                if( ( counter < lista.size() )  ) {
                /*Pt debug~~~*/
                    System.out.println("counter este:"+counter);
                /*~~~~~~~~~~~*/
                    return lista.get(counter++);
                }
            }catch(NoSuchElementException e){
                System.out.println("Out of bounds");
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Invalid action!");
        }

    }
}

