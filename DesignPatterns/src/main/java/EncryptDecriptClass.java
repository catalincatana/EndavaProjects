import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ccatana on 5/13/2014.
 */
public class EncryptDecriptClass implements EncryptDecrypt {
    @Override
    public String encryptAL(String sir) {

        ArrayList<LetterMapping> lt = TestClass.generatesArrayList();
        String listaFinala="";

        for(int i=0;i<sir.length();i++){

            for(int j=0;j<lt.size();j++){

                if(sir.charAt(i) == lt.get(j).s){
                    listaFinala = listaFinala + (Integer.toString(lt.get(j).i))+" " ;
                    break;
                }
            }

        }


        return listaFinala;
    }

    @Override
    public String decryptAL(String sir) {

        ArrayList<LetterMapping> lt = TestClass.generatesArrayList();
        String listaFinala="";
        String partial="";
        int counter = 0;
        for(int i=0;i<sir.length();i++) {

            if (!(String.valueOf(sir.charAt(i)).equals(" "))) {
                partial = partial + String.valueOf(sir.charAt(i));

            }else{
                for (int j = 0; j < lt.size(); j++) {
                    if (partial.equals(Integer.toString(lt.get(j).i))) {
                        listaFinala = listaFinala + String.valueOf(lt.get(j).s);
                    }
                }
                partial = "";
            }
        }

        return listaFinala;
    }

    @Override
    public String encryptHMP(String sir) {

        HashMap<String, Integer> hmlst = TestClass.generatesHashMap();
        String listaFinala="";

        for(int i=0;i<sir.length();i++){

                if(hmlst.containsKey(String.valueOf(sir.charAt(i)))){

                    listaFinala = listaFinala + hmlst.get(String.valueOf(sir.charAt(i))) + " ";

                }

        }


        return listaFinala;
    }

    @Override
    public String decryptHMP(String sir) {


        HashMap<String, Integer> hmlst = TestClass.generatesHashMap();
        String listaFinala="";
        String partial="";

        for(int i=0;i<sir.length();i++){
            if (!(String.valueOf(sir.charAt(i)).equals(" "))) {
                partial = partial + String.valueOf(sir.charAt(i));

            }else {
                //hmlst.get(s) intoarce un integer asa ca in Integer.parseInt(String.valueOf(sir.charAt(i)))) convertesc char-ul in string apoi in integer
                for (String s : hmlst.keySet()) {

                    if (hmlst.get(s).equals(Integer.parseInt(partial)))
                        listaFinala = listaFinala + s;

                }
                partial="";

            }
        }

        return listaFinala;
    }
}
