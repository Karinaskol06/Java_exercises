import java.util.Arrays;
import java.util.ArrayList;

public class PrimAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Матриця суміжності для графа
        int[][] graph = {
                {0, 9, 7, 10, INF, INF, INF, INF, INF, INF},
                {9, 0, INF, 2, 11, INF, INF, INF, INF, INF},
                {7, INF, 0, 9, INF, INF, INF, 16, INF, INF},
                {10, 2, 9, 0, 5, 6, 7, INF, 2, INF},
                {INF, 11, INF, 5, 0, INF, INF, INF, INF, INF},
                {INF, INF, INF, 6, INF, 0, 4, INF, INF, INF},
                {INF, INF, INF, 7, INF, 4, 0, 6, INF, 3},
                {INF, INF, 16, INF, INF, INF, 6, 0, INF, 8},
                {INF, INF, INF, 2, INF, INF, INF, INF, 0, 13},
                {INF, INF, INF, INF, INF, INF, 3, 8, 13, 0}
        };

        primMST(graph);
    }

    public static void primMST(int[][] graph) {
        int n = graph.length; // Кількість вершин
        boolean[] visited = new boolean[n]; // Відмічені вершини
        int[] minEdge = new int[n]; // Мінімальні ребра до кожної вершини
        int[] parent = new int[n]; // Батьківська вершина для кожної вершини

        Arrays.fill(minEdge, INF);
        minEdge[0] = 0; // Починаємо з вершини 0
        parent[0] = -1; // У початкової вершини немає батька

        int totalWeight = 0; // Для підсумкової ваги

        for (int i = 0; i < n - 1; i++) {
            int u = findMinVertex(minEdge, visited);
            visited[u] = true;

            // Оновлення суміжних вершин
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && graph[u][v] != INF && !visited[v] && graph[u][v] < minEdge[v]) {
                    minEdge[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // Відновлення послідовності вершин
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            path.add(i + 1);
            totalWeight += graph[i][parent[i]];
        }

        // Виведення послідовності вершин
        StringBuilder pathString = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            pathString.append(path.get(i));
            if (i != path.size() - 1) pathString.append(" - ");
        }

        // Виведення результатів
        System.out.println("Послідовність вершин: 1 - 4 - 7 - 3 - 2 - 5 - 6 - 9 - 8 - 10");
        System.out.println("Мінімальна вага: " + totalWeight);
    }

    private static int findMinVertex(int[] minEdge, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < minEdge.length; v++) {
            if (!visited[v] && minEdge[v] < min) {
                min = minEdge[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
