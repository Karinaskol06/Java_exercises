package AlgorithmsJava;

import java.util.*;

class Graph {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
    class Subset {
        int parent, rank;
    }
    private int V;
    private ArrayList<Edge> edges;
    public Graph(int v) {
        V = v;
        edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int w) {
        Edge newEdge = new Edge();
        newEdge.src = u;
        newEdge.dest = v;
        newEdge.weight = w;
        edges.add(newEdge);
    }

    private int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    private void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public void kruskalMST() {
        Edge[] result = new Edge[V - 1];
        int e = 0;
        int i = 0;

        Collections.sort(edges);

        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        i = 0;

        while (e < V - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }
        System.out.println("Edge    Weight");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + "   " + result[i].weight);
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) {
        Graph g = new Graph(11);

        g.addEdge(2, 4, 2);
        g.addEdge(4, 9, 2);
        g.addEdge(5, 6, 4);
        g.addEdge(7, 9, 3);
        g.addEdge(7, 10, 6);
        g.addEdge(4, 6, 5);
        g.addEdge(7, 8, 8);
        g.addEdge(1, 4, 9);
        g.kruskalMST();
    }
}