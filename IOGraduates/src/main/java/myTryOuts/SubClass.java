package myTryOuts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by ccatana on 5/9/2014.
 */
public class SubClass extends SuperClass implements Serializable {
    private String nume;

    SubClass(String nume){
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString(){
        return "SubClass{id="+getId()+",value="+getValue()+",name="+getNume()+"}";
    }

    public void writeObject(ObjectOutputStream oos){
        try {
            oos.defaultWriteObject();
            oos.writeInt(getId());
            oos.writeObject(getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readObject (ObjectInputStream ois){
        try {
            ois.defaultReadObject();

            setId(ois.readInt());
            setValue((String) ois.readObject());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*Testare*/
    public static void main(String[] args) {
        String fileName = "cazul1.txt";
        SubClass copil = new SubClass("MAMA");

        copil.setId(10);
        copil.setValue("YOYO");

        try {
            System.out.println(Serialization.serialize(copil,fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            System.out.println("Deserializat:" + Serialization.deserialize(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

}
