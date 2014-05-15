import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

/**
 * Created by ccatana on 5/13/2014.
 */
public class TestClass {
    private static Random r = new Random();
    private static Random r2 = new Random();

    public static void main(String[] args) {

        String linie ="";
        String linieHMP = "";


        ArrayList<LetterMapping> lt = generatesArrayList();

        System.out.println(lt);

        HashMap<String, Integer> hmlst = generatesHashMap();

        System.out.println(hmlst);

        try {
            AbstractFactorySingleton afs = AbstractFactorySingleton.getInstance();
            EncryptDecrypt edc;

            edc = afs.createFactory(AbstractFactorySingleton.TipuriCriptari.Criptare1);
            /*Testul local*/

/*
            String sir="ABC";
            
            String sirCriptat = "";
            sirCriptat = edc.encryptAL(sir);

            System.out.println("sizeee:"+sirCriptat.length()); //de lucrat un pic
            System.out.println("======================");

                System.out.println("Sirul criptat cu tipul 1 este: " + sirCriptat);

            String sirDecriptat = "";
            sirDecriptat = edc.decryptAL(sirCriptat);

                System.out.println("Sirul decriptat cu tipul 1 este: " + sirDecriptat);

            String sirHMP = "BCA";
            String sirCriptatHMP = "";
            sirCriptatHMP = edc.encryptHMP(sirHMP);

                System.out.println("Sirul criptat(hashmap) cu tipul 1 este: " + sirCriptatHMP);


            String sirDecriptatHMP  = edc.decryptHMP(sirCriptatHMP);

                System.out.println("Sirul decriptat(hashmap) cu tipul 1 este: " + sirDecriptatHMP);

*/
            File file = new File("DesignPatternAL.txt");
            FileOutputStream fop = new FileOutputStream(file);
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            /*Fisierul in care scriem text criptat*/
            File fisier = new File("CriptatAL.txt");
            FileOutputStream fisierop = new FileOutputStream(fisier);
            if (!fisier.exists()) {
                fisier.createNewFile();
            }
            /*Fisierul in care scriem text criptat*/
            File fisierDecriptat = new File("DecriptatAL.txt");
            FileOutputStream decriptatfile = new FileOutputStream(fisierDecriptat);
            if (!fisierDecriptat.exists()) {
                fisierDecriptat.createNewFile();
            }


            BufferedWriter writer2 = null;
            writer2 = new BufferedWriter(new FileWriter(fisier));

            BufferedWriter writer3 = null;
            writer3 = new BufferedWriter(new FileWriter(fisierDecriptat));

        /*Scrierea in fisier*/
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter(file));
            for(int i=0;i<100;i++){
                linie="";
                String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                for (int j = 0; j < 80; j++) {
                    linie = linie + alphabet.charAt(r.nextInt(alphabet.length()));
                } // prints 50 random characters from alphabet
                writer.write(linie );
                writer.newLine();
            }
            writer.close();

         /*Citirea din fisier si criptare*/
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            final long startTime = System.currentTimeMillis();
            while ((line = br.readLine()) != null) {
                String cryptedLine = edc.encryptAL(line);
                writer2.write(cryptedLine);
                writer2.newLine();

            }
              final long endTime = System.currentTimeMillis();

               System.out.println("Total execution time Encrypt1AL: " + (endTime - startTime) );

            br.close();
            writer2.close();

            /*Fisierul decriptat*/
            BufferedReader br2 = new BufferedReader(new FileReader(fisier));
            String line2;

            final long startTimeDecrypt = System.currentTimeMillis();
            while ((line2 = br2.readLine()) != null) {
                String cryptedLine = edc.decryptAL(line2);
                writer3.write(cryptedLine);
                writer3.newLine();
            }

            final long endTimeDecrypt = System.currentTimeMillis();

            System.out.println("Total execution time Decrypt1AL: " + (endTimeDecrypt - startTimeDecrypt) );
            br2.close();
            writer3.close();

            System.out.println("============================");

            File fileHMP = new File("DesignPatternHMP.txt");
            FileOutputStream fopHMP = new FileOutputStream(fileHMP);
            // if file doesn't exists, then create it
            if (!fileHMP.exists()) {
                fileHMP.createNewFile();
            }
            /*Fisierul in care scriem text criptat*/
            File fisierHMP = new File("CriptatHMP.txt");
            FileOutputStream fisieropHMP = new FileOutputStream(fisierHMP);
            if (!fisierHMP.exists()) {
                fisierHMP.createNewFile();
            }
            /*Fisierul in care scriem text criptat*/
            File fisierDecriptatHMP = new File("DecriptatHMP.txt");
            FileOutputStream decriptatfileHMP = new FileOutputStream(fisierDecriptatHMP);
            if (!fisierDecriptatHMP.exists()) {
                fisierDecriptatHMP.createNewFile();
            }


            BufferedWriter writer2HMP = null;
            writer2HMP = new BufferedWriter(new FileWriter(fisierHMP));

            BufferedWriter writer3HMP = null;
            writer3HMP = new BufferedWriter(new FileWriter(fisierDecriptatHMP));

        /*Scrierea in fisier*/
            BufferedWriter writerHMP = null;
            writerHMP = new BufferedWriter(new FileWriter(fileHMP));
            for(int i=0;i<100;i++){
                linieHMP="";
                String alphabet2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                for (int j = 0; j < 80; j++) {
                    linieHMP = linieHMP + alphabet2.charAt(r2.nextInt(alphabet2.length()));
                } // prints 50 random characters from alphabet
                writerHMP.write(linieHMP );
                writerHMP.newLine();
            }
            writerHMP.close();

         /*Citirea din fisier si criptare*/
            BufferedReader brHMP = new BufferedReader(new FileReader(fileHMP));
            String lineHMP;

            final long startTimeHMP = System.currentTimeMillis();
            while ((lineHMP = brHMP.readLine()) != null) {
                String cryptedLineHMP = edc.encryptHMP(lineHMP);
                writer2HMP.write(cryptedLineHMP);
                writer2HMP.newLine();

            }
            final long endTimeHMP = System.currentTimeMillis();

            System.out.println("Total execution time Encrypt1HMP: " + (endTimeHMP - startTimeHMP) );

            brHMP.close();
            writer2HMP.close();

            /*Fisierul decriptat*/
            BufferedReader br2HMP = new BufferedReader(new FileReader(fisierHMP));
            String line2HMP;

            final long startTimeDecryptHMP = System.currentTimeMillis();
            while ((line2HMP = br2HMP.readLine()) != null) {
                String cryptedLineHMP2 = edc.decryptHMP(line2HMP);
                writer3HMP.write(cryptedLineHMP2);
                writer3HMP.newLine();

            }

            final long endTimeDecryptHMP = System.currentTimeMillis();

            System.out.println("Total execution time Decrypt1HMP: " + (endTimeDecryptHMP - startTimeDecryptHMP) );
            br2HMP.close();
            writer3HMP.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<LetterMapping> generatesArrayList(){
        List<LetterMapping> lst = new ArrayList<LetterMapping>();

        char s = 'A';

        for (int i = 1; i < 27; i++) {

            lst.add(new LetterMapping(s, i));
            s++;

        }
        return (ArrayList<LetterMapping>) lst;

    }

    public static HashMap<String, Integer> generatesHashMap(){
        Map<String, Integer> hmlst = new HashMap<String, Integer>();

        char s = 'A';

        for (int i = 1; i < 27; i++) {

            hmlst.put(String.valueOf(s), new Integer(i));
            s++;

        }
        return (HashMap<String, Integer>) hmlst;

    }
}
