package AlgorithmsJava;

import java.util.Scanner;

public class Floyd_Algorithm {
    static final int maxV = 1000;
    static int[][] g = new int[maxV][maxV];
    static int n;

    static void floydWarshall(int[][] d, int v) {
        for (int i = 0; i < v; i++)
            d[i][i] = 0;

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (d[i][k] != 0 && d[k][j] != 0 && i != j) {
                        if (d[i][j] == 0 || d[i][k] + d[k][j] < d[i][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                        }
                    }
                }
            }
        }

        //матриця найкоротших шляхів
        System.out.println("Матриця найкоротших шляхів:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(d[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Кількість вершин в графі: ");
        n = scanner.nextInt();
        System.out.println("Введіть матрицю ваг ребер графа:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("B[" + (i + 1) + "][" + (j + 1) + "]=");
                g[i][j] = scanner.nextInt();
            }
        }
        floydWarshall(g, n);
        scanner.close();
    }
}
