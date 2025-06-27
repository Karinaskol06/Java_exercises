package SimpleSyntax;
import java.util.Arrays;
public class ArraySyntax {
    public static void main(String[] args) {

        int[] numsArr = {333, 921, -29, 26761, 0, 17625, 8, 111, -2333, 82};

        /*numsArr[0] = -778;
        numsArr[1] = 46736;
        numsArr[2] = 72;
        numsArr[3] = 8;
        numsArr[4] = 200;
        numsArr[5] = 43;
        numsArr[6] = -18273;
        numsArr[7] = 3;
        numsArr[8] = 1625;
        numsArr[9] = 909;*/

        int min, max;

        min = max = numsArr[0];

        for (int i = 1; i < numsArr.length; i++) {
            if (numsArr[i] < min) min = numsArr[i];
            System.out.println("At the iteration " + i + " min is " + min);
            if (numsArr[i] > max) max = numsArr[i];
            System.out.println("At the iteration " + i + " max is " + max);
        }
        System.out.println("At the end of the cycle the min element is: " + min +
                ", the max: " + max);
    }
}
