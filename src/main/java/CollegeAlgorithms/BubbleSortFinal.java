package CollegeAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BubbleSortFinal {
    public static void main(String[] args) {
        int[] array = {5, 2, 7, 9, 1, 3};
        System.out.println("Початковий масив:");
        printArray(array);
        bubbleSort(array);
        System.out.println("Відсортований масив:");
        printArray(array);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());




    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        int step = 1;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.print("Крок " + step++ + ": ");
            printArray(arr);
            if (!swapped) break;
        }
    }
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}


