package SimpleSyntax;

public class ArrayOperations {
    public static void main(String[] args) {
        System.out.println("The number of arguments: " + args.length);

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        /* int[] arr1 = {999, 2738, 9, 109, -2, 3333, 1};
        int[] arr2 = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }

        for (int j : arr2) {
            System.out.print(j + " ");
        }*/

    }
}
