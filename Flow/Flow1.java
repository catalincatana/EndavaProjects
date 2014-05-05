import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by ccatana on 5/5/2014.
 */
public class Flow1 {
    public static void main(String[] args) {
        int i = 3;
        switch (i) {
            case 0:
                System.out.println("zero");
                break;
            default:
                System.out.println("default");
                break;
            case 3:
                System.out.println("three");
            case 1:
                System.out.println("one");
        }

        System.out.println("=====================");
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        for (int item : numbers) {
            System.out.println("Count is: " + item);
        }

        System.out.println("=====================");
        for (int j = 0; j < 100; j++) {
            if (j == 10) {
                break;
            }
            System.out.println("j=" + j);
        }
        System.out.println("=====================");
        boolean b = true;
        first : {
            second : {
                third : {
                    System.out.println("Inside the third block");
                    if (b) {
                        break second;
                    }
                }
                System.out.println("Inside the second block");  //  nu se va executa
            }
            System.out.println("Inside the first block");
        }

        System.out.println("========================");
        for (int k = 0; k < 10; k++) {
            System.out.print(k + " ");
            if (k % 2 == 0) {
                continue;
            }
            System.out.println();  //  trec la linie noua doar daca i este impar
        }
        System.out.println("=======================");
        outer: for (int m = 0; m < 10; m++) {
            for (int n = 0; n < 10; n++) {
                if (n > m) {
                    System.out.println();
                    continue outer;
                }
                System.out.print(" " + (m * n));
            }
        }
        //se incheie main
    }
}
