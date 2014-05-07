import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccatana on 5/6/2014.
 */
class Masini  {

}

class Dacia extends Masini {
    public Dacia(){
        //System.out.println("Sunt o dacie!");
    }
}

class Avion {

}

interface Pair< K,V>{
    public K getKey();
    public V getValue();
}

public class Generics<K,V> implements Pair<K,V> {
    //Multiplii parametrii de tip
    private K key;
    private V value;


    // Metode generice
    public static <K,V> boolean compare(K o1, V o2){
        return o1.equals(o2);
    }

    public Generics(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hi");
        String s= (String) list.get(0);
        System.out.println(s);
        System.out.println(" ============ ");

        // nu mai trebuie cast pentru ca impunem ca lista 2 sa contina numai Stringuri
        List<String> lista2 = new ArrayList<String>();
        lista2.add("Ce faaci vere?");
        String s2 = lista2.get(0);
        System.out.println(s2);
        System.out.println(" ============== ");

    //Avem o lista ce contine Masini si putem adauga in ea si obiecte de subtipul Masini-> Dacia
        Dacia logan  = new Dacia();
        List<Masini> masinute = new ArrayList<Masini>();
        masinute.add(logan);
        System.out.println(masinute.get(0));

    //Nu putem adauga obiecte care nu sunt de tipul sau subtipul clasei generic
        Avion boeing = new Avion();
        masinute.add(boeing);

        System.out.println("============");
        Integer p1 = 36;
        String  p2 = "33";
        //System.out.println(Integer.parseInt("A"));
        boolean same = compare(65,"A");
        System.out.println(same);
        System.out.println("==================");

    //Multiplii Parametrii de tip

        Generics<String,Integer> c1 = new Generics<String, Integer>("Cata",29);
        Generics<String,String> c2 = new Generics<String, String>("Cata","AOLEU");
        System.out.println(c1.getKey());
        System.out.println(c1.getValue());
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}


