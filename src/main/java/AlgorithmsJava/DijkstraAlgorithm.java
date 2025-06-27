package AlgorithmsJava;

import java.util.*;

class Dijkstra {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(Map<Integer, List<Edge>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;

            if (visited[u]) continue;
            visited[u] = true;

            for (Edge neighbor : graph.getOrDefault(u, new ArrayList<>())) {
                int v = neighbor.to, weight = neighbor.weight;
                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }

        System.out.println("Початок від вершини " + start + ":");
        for (int i = 1; i <= n; i++) {
            System.out.println("До " + i + " = " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        graph.put(1, Arrays.asList(new Edge(4, 5)));
        graph.put(2, Arrays.asList(new Edge(4, 13), new Edge(5, 7)));
        graph.put(3, Arrays.asList(new Edge(4, 8), new Edge(5, 6)));
        graph.put(4, Arrays.asList(new Edge(1, 5), new Edge(2, 13), new Edge(3, 8), new Edge(5, 1), new Edge(6, 7)));
        graph.put(5, Arrays.asList(new Edge(2, 7), new Edge(3, 6), new Edge(4, 1), new Edge(6, 4)));
        graph.put(6, Arrays.asList(new Edge(4, 7), new Edge(5, 4)));

        System.out.println("Знаходимо найкоротші відстані від початкової вершини: ");
        dijkstra(graph, 4);
    }
}