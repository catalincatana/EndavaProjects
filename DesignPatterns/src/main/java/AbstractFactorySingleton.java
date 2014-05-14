import java.util.ArrayList;

/**
 * Created by ccatana on 5/13/2014.
 */
public class AbstractFactorySingleton  {
    //criptare1 -> A=1, B=2; criptare2-> A=27, B=26;
    public enum TipuriCriptari{
        Criptare1,Criptare2
    }

    private static  AbstractFactorySingleton instance = null;

   private AbstractFactorySingleton()  {

    }

    public static AbstractFactorySingleton getInstance(){
        if (instance == null){
            instance = new AbstractFactorySingleton();
        }
        return instance;
    }

    public static EncryptDecrypt createFactory(TipuriCriptari tipuriCriptari){ //la return este interfata:)
        switch(tipuriCriptari){
            case Criptare1: return new EncryptDecriptClass();
            //case Criptare2: return new EncryptDecriptClass2();
        }
        throw new IllegalArgumentException("Nu este un tip de pizza valid!");
    }
    //de facut cu enum {tip1 si tip2)
    //de facut metoda create in functie de enum(tip1-> sau tip2->)
}
