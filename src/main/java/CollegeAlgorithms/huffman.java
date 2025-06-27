package CollegeAlgorithms;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

class Node {
    char symbol;
    int frequency;
    Node left;
    Node right;

    Node(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    Node(int frequency, Node left, Node right) {
        this.symbol = '\0';
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}

class NodeComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2) {
        return n1.frequency - n2.frequency;
    }
}

public class huffman {
    public static Node buildHuffmanTree(char[] symbols, int[] frequencies) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new NodeComparator());

        for (int i = 0; i < symbols.length; i++) {
            priorityQueue.add(new Node(symbols[i], frequencies[i]));
        }

        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node newNode = new Node(left.frequency + right.frequency, left, right);
            priorityQueue.add(newNode);
        }

        return priorityQueue.poll();
    }

    public static void generateCodes(Node root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.symbol, code);
        }

        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    public static void main(String[] args) {
        char[] symbols = {'р', 'е', 'м', 'о', 'н', '1', '5', '3', '2', '7'};
        int[] frequencies = {1, 1, 1, 1, 1, 2, 2, 2, 3, 3};

        Node root = buildHuffmanTree(symbols, frequencies);

        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        System.out.println("Символи та їх кодові комбінації:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}