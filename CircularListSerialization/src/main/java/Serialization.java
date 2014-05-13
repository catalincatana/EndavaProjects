/**
 * Created by ccatana on 5/13/2014.
 */

import java.io.*;
import java.util.Objects;

/**
 * Created by ccatana on 5/9/2014.
 */
public class Serialization {

    public static Object deserialize(String numeFisier) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(numeFisier);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obiect = ois.readObject();
        ois.close();
        return obiect;
    }

    public static Object serialize(Object obiect,String numeFisier) throws IOException, ClassNotFoundException{
        FileOutputStream fos = new FileOutputStream(numeFisier);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obiect);
        fos.close();
        return obiect;
    }

}
