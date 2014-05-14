import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ccatana on 5/13/2014.
 */
public class EncryptDecriptClass implements EncryptDecrypt {
    @Override
    public String encryptAL(String sir) {
       // final long startTime = System.currentTimeMillis();

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
      //  final long endTime = System.currentTimeMillis();

     //   System.out.println("Total execution time Encrypt1AL: " + (endTime - startTime) );

        return listaFinala;
    }

    @Override
    public String decryptAL(String sir) {
       // final long startTime = System.currentTimeMillis();

        ArrayList<LetterMapping> lt = TestClass.generatesArrayList();
        String listaFinala="";
        String partial="";

        for(int i=0;i<sir.length();i++) {
            while (String.valueOf(sir.charAt(i)) != " ") {
                partial = partial + String.valueOf(sir.charAt(i));
            }
        }
            for(int j=0;j<lt.size();j++){

                if(partial .equals( Integer.toString(lt.get(j).i))) {
                    listaFinala = listaFinala + String.valueOf(lt.get(j).s);
                }
            }



      //  final long endTime = System.currentTimeMillis();

      //  System.out.println("Total execution time Decrypt1AL: " + (endTime - startTime) );
        return listaFinala;
    }

    @Override
    public String encryptHMP(String sir) {
        final long startTime = System.currentTimeMillis();

        HashMap<String, Integer> hmlst = TestClass.generatesHashMap();
        String listaFinala="";

        for(int i=0;i<sir.length();i++){

                if(hmlst.containsKey(String.valueOf(sir.charAt(i)))){

                    listaFinala = listaFinala + hmlst.get(String.valueOf(sir.charAt(i)));

                }

        }

        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time(Encrypt1HMP): " + (endTime - startTime) );
        return listaFinala;
    }

    @Override
    public String decryptHMP(String sir) {
        final long startTime = System.currentTimeMillis();

        HashMap<String, Integer> hmlst = TestClass.generatesHashMap();
        String listaFinala="";

        for(int i=0;i<sir.length();i++){

            //hmlst.get(s) intoarce un integer asa ca in Integer.parseInt(String.valueOf(sir.charAt(i)))) convertesc char-ul in string apoi in integer
            for(String s : hmlst.keySet()){
                if(hmlst.get(s).equals(Integer.parseInt(String.valueOf(sir.charAt(i)))))
                    listaFinala = listaFinala + s;
            }

        }
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time(decrypt1HMP): " + (endTime - startTime) );
        return listaFinala;
    }
}
