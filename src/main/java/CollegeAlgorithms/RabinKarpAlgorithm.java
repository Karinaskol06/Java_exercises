package CollegeAlgorithms;

import java.util.*;

public class RabinKarpAlgorithm {

    public static void main(String[] args) {
        String text = "ssfaffcfcffcfqasfs";
        String pattern = "ffcfcffcfq";
        int prime = 11;
        System.out.println("Текст: " + text);
        System.out.println("Підрядок: " + pattern);
        System.out.println("Просте число q: " + prime);
        System.out.println();
        rabinKarpSearch(text, pattern, prime);
    }

    public static void rabinKarpSearch(String text, String pattern, int prime) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int base = 10; //розмір алфавіту

        //map для кодування символів
        Map<Character, Integer> charToCode = createCharMapping(text, pattern);

        //кодування тексту і підрядку
        int[] encodedText = encodeString(text, charToCode);
        int[] encodedPattern = encodeString(pattern, charToCode);
        System.out.println("Закодований текст: " + Arrays.toString(encodedText));
        System.out.println("Закодований підрядок: " + Arrays.toString(encodedPattern));
        System.out.println();

        long h = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            h = (h * base) % prime;
        }
        System.out.println("h = " + base + "^" + (patternLength-1) + " mod " + prime + " = " + h);

        //розрахунок хешу підрядка
        long patternHash = 0;
        for (int i = 0; i < patternLength; i++) {
            patternHash = (patternHash * base + encodedPattern[i]) % prime;
        }
        System.out.println("Хеш підрядка P: " + patternHash);
        System.out.println();

        long textHash = 0;
        for (int i = 0; i < patternLength; i++) {
            textHash = (textHash * base + encodedText[i]) % prime;
        }

        boolean found = false;
        //список зі співпадіннями
        List<Integer> matches = new ArrayList<>();

        //перевірка всіх позицій
        for (int i = 0; i <= textLength - patternLength; i++) {
            //перевірка хешу
            if (textHash == patternHash) {
                boolean exactMatch = true;
                for (int j = 0; j < patternLength; j++) {
                    if (encodedText[i + j] != encodedPattern[j]) {
                        exactMatch = false;
                        break;
                    }
                }
                if (exactMatch) {
                    matches.add(i);
                    found = true;
                }
            }

            //оновлення хешу для наступної позиції
            if (i < textLength - patternLength) {
                textHash = (base * (textHash - encodedText[i] * h) + encodedText[i + patternLength]) % prime;
                if (textHash < 0) {
                    textHash += prime;
                }
            }
        }

        //виведення результату
        if (found) {
            for (int pos : matches) {
                System.out.println("Позиція " + pos );
            }
        } else {
            System.out.println("Підрядок не знайдено");
        }
    }

    private static Map<Character, Integer> createCharMapping(String text, String pattern) {
        Map<Character, Integer> charToCode = new HashMap<>();
        charToCode.put('s', 0);
        charToCode.put('f', 1);
        charToCode.put('a', 2);
        charToCode.put('c', 3);
        charToCode.put('q', 4);

        return charToCode;
    }

    //кодування рядка в масив чисел
    private static int[] encodeString(String str, Map<Character, Integer> charToCode) {
        int[] encoded = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            encoded[i] = charToCode.get(str.charAt(i));
        }
        return encoded;
    }
}