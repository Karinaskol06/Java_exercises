package CollegeAlgorithms;

import java.util.Random;

public class InsertionSort {
    public static void printArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void insertionSort(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            char key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int t = 0; t < 10; t++) {
            int n = rand.nextInt(16) + 5;
            char[] arr = new char[n];

            for (int i = 0; i < n; i++) {
                arr[i] = (char) (rand.nextInt(26) + 'a');
            }
            System.out.println("Початковий масив заповнений рандомно з " + n + " символами:");
            printArray(arr);
            insertionSort(arr);
            System.out.println("Відсортований:");
            printArray(arr);
            System.out.println();
        }
    }
}

