package AlgorithmsJava;
import java.util.Scanner;
public class LinearSearch {
    public static void main(String[] args) {
        String str1 = "My name is ";
        String str2 = str1;
        String[][] arrStr = new String[3][5];
        boolean isFoung = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your answers: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                arrStr[i][j] = sc.nextLine();
            }
        }
         for (String[] x : arrStr) {
             int counter = 0;
             for (String y : x) {
                 if (counter == 5){
                     System.out.print("\n");
                     counter = 0;
                 } else{
                     System.out.print(y + " ");
                     counter++;
                 }
             }
         }
    }
}
