package AlgorithmsJava;
import java.util.Scanner;
public class BubbleStrings {
    public static void main(String[] args) {

        //declaration of an array with 10 elements
        var bubbleArr = new String[5];

        //declaration of a scanner
        var sc = new Scanner(System.in);

        //initializing array with numbers that user enters
        for (int i = 0; i < bubbleArr.length; i++) {
            System.out.print("Enter a word: ");
            bubbleArr[i] = sc.nextLine();
        }

        //bubble sorting the array
        for (int i = 0; i < bubbleArr.length - 1; i++) {
            for (int j = 0; j < bubbleArr.length - i - 1; j++) {
                if (bubbleArr[j].compareTo(bubbleArr[j + 1]) > 0) {
                    String temp = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j + 1];
                    bubbleArr[j + 1] = temp;
                }
            }
        }

        //printing the array
        System.out.println("The bubble array is: ");
        for (String s : bubbleArr) {
            System.out.print(s + " ");
        }
    }
}
