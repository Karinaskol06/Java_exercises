package AlgorithmsJava;
import java.util.Scanner;
public class Bubble {
    public static void main(String[] args) {

        //declaration of an array with 10 elements
        int[] bubbleArr = new int[10];

        //declaration of a scanner
        Scanner sc = new Scanner(System.in);

        //initializing array with numbers that user enters
        for (int i = 0; i < bubbleArr.length; i++) {
            System.out.print("Enter number: ");
            bubbleArr[i] = sc.nextInt();
        }

        //bubble sorting the array
        for(int i = 0; i < bubbleArr.length; i++){
            for (int j = bubbleArr.length - 1; j > i; j--){
                if (bubbleArr[j - 1] > bubbleArr[j]){
                    int temp = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j-1];
                    bubbleArr[j - 1] = temp;
                }
            }
        }

        //printing the array
        System.out.println("The bubble array is: ");
        for (int j : bubbleArr) {
            System.out.print(j + " ");
        }
    }
}
