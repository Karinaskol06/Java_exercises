package CollegeAlgorithms;

import java.util.*;

public class BoyerMooreSearch {
    public static Map<Character, Integer> buildBadCharacterTable(String pattern) {
        Map<Character, Integer> badCharTable = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            badCharTable.put(pattern.charAt(i), i);
        }
        return badCharTable;
    }

    public static List<Integer> boyerMooreSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> badCharTable = buildBadCharacterTable(pattern);

        int n = text.length();
        int m = pattern.length();
        int i = 0;
        while (i <= n - m) {
            int j = m - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(i + j)) {
                j--;
            }

            if (j < 0) {
                result.add(i);
                i += 1;
            } else {
                char mismatchedChar = text.charAt(i + j);
                int lastOccurrence = badCharTable.getOrDefault(mismatchedChar, -1);
                int shift = Math.max(1, j - lastOccurrence);
                i += shift;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Queue<String> queue1 = new LinkedList<>();
        queue1.add("рядок 1");
        queue1.add("рядок 2");
        queue1.add("рядок 3");


        String text = "ssfaffcfcffcfqasfs";
        String pattern = "ffcfcffcfq";
        List<Integer> positions = boyerMooreSearch(text, pattern);
        if (positions.isEmpty()) {
            System.out.println("Зразок не знайдено у тексті.");
        } else {
            System.out.println("Зразок знайдено на позиціях:");
            for (int pos : positions) {
                System.out.println("Позиція: " + pos + " (зсув S = " + pos + ")");
            }
        }
    }
}
