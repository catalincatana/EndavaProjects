import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.ErrorManager;

/**
 * Created by ccatana on 5/5/2014.
 */
public class CataExceptions {

    public static void writeList() {
        PrintWriter out = null;
        ErrorManager logger = null;
        int[] lista = {1,2,3,4};
        try {
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < lista.length; i++)
                out.println("Value at: " + i + " = " + lista[i+1]); //pun i+1 s avad ca prinde eroarea
        } catch (ArrayIndexOutOfBoundsException e){
           // assert logger != null;
         //   logger.error(e.getMessage());
            System.out.println("Array afar din bounds :)");
        }catch (IOException e){
         //   logger.error(e.getMessage());
            System.out.println("Nasoala treaba la citire :(");
        }
        catch(Exception e){
            // do something else. If you want to do logger.error, add another | to 	// the catch above
            System.out.println(" Prindem rebuturi :X");
        }finally{
            if (out != null) {
                out.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            int divisionResult = 4 / 0;
        } catch(ArithmeticException e) {
            //e.printStackTrace();
            System.out.println("eroare");
        }
        writeList();
    }
}
