package CollegeAlgorithms;

import java.util.*;

class ShannonNode {
    char data;
    double freq;
    String code;

    ShannonNode(char data, double freq) {
        this.data = data;
        this.freq = freq;
        this.code = "";
    }
}

public class Shennon {

    public static void shannonFano(List<ShannonNode> nodes, int start, int end) {
        if (start >= end) {
            return;
        }

        double totalFreq = 0;
        for (int i = start; i <= end; i++) {
            totalFreq += nodes.get(i).freq;
        }

        double halfFreq = 0;
        int splitIndex = start;
        for (int i = start; i <= end; i++) {
            halfFreq += nodes.get(i).freq;
            if (halfFreq >= totalFreq / 2) {
                splitIndex = i;
                break;
            }
        }

        for (int i = start; i <= splitIndex; i++) {
            nodes.get(i).code += "0";
        }
        for (int i = splitIndex + 1; i <= end; i++) {
            nodes.get(i).code += "1";
        }

        shannonFano(nodes, start, splitIndex);
        shannonFano(nodes, splitIndex + 1, end);
    }

    public static void printCodes(List<ShannonNode> nodes) {
        for (ShannonNode node : nodes) {
            System.out.println(node.data + ": " + node.code);
        }
    }

    public static void shannonFanoCodes(Map<Character, Integer> freqMap) {
        List<ShannonNode> nodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            nodes.add(new ShannonNode(entry.getKey(), entry.getValue()));
        }

        nodes.sort((a, b) -> Double.compare(b.freq, a.freq));

        shannonFano(nodes, 0, nodes.size() - 1);

        printCodes(nodes);
    }

    public static void main(String[] args) {
        String input = "номер372557732211";

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        System.out.println("Метод Шеннона-Фано:");
        shannonFanoCodes(freqMap);
    }
}
