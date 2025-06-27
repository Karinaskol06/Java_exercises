package CollegeAlgorithms;

public class KMPAlgorithm {
    public static int[] prefixFunction(String P) {
        int[] f = new int[P.length()];
        f[0] = 0;
        int k = 0;
        for (int i = 1; i < P.length(); i++) {
            while (k > 0 && P.charAt(k) != P.charAt(i)) {
                k = f[k - 1];
            }
            if (P.charAt(k) == P.charAt(i)) {
                k++;
            }
            f[i] = k;
        }
        return f;
    }
    public static int kmpSearch(String T, String P) {
        int[] f = prefixFunction(P);
        int k = 0;
        for (int i = 0; i < T.length(); i++) {
            while (k > 0 && P.charAt(k) != T.charAt(i)) {
                k = f[k - 1];
            }
            if (P.charAt(k) == T.charAt(i)) {
                k++;
            }
            if (k == P.length()) {
                return i - P.length() + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String P = "ffcfcffcfq";
        String T = "ssfaffcfcffcfqasfs";
        int[] prefixFunc = prefixFunction(P);
        System.out.println("Префіксна для P:");
        for (int i = 0; i < prefixFunc.length; i++) {
            System.out.printf("f[%d] = %d\n", i+1, prefixFunc[i]);
        }

        int position = kmpSearch(T, P);
        if (position != -1) {
            System.out.println("Зразок знайдено на позиції: " + position);
            System.out.println("Зсув S = " + position);
            System.out.println("Зразок входить у текст з позиції " +
                    position + " до " + (position + P.length() - 1));
        } else {
            System.out.println("Зразок не знайдено у тексті.");
        }
    }
}
