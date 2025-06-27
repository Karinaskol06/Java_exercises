package SimpleSyntax;
import java.util.Scanner;
public class ArrAvg {
    public static void main(String[] args){

        double[] myArr = new double[10];
        Scanner sc = new Scanner(System.in);
        double temp = 0;

        System.out.println("Enter random numbers: ");
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = sc.nextDouble();
        }

        for (double el : myArr){
            temp += el;
        }
        System.out.println("The average of all the numbers in the array is: " + temp/myArr.length);
        temp = 0;

    }

}
