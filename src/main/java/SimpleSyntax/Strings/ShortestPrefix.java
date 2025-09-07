package SimpleSyntax.Strings;

public class ShortestPrefix {
    public static String getPrefix(String first, String second){
        int bound = Math.min(first.length(), second.length());
        int commonLetters = 0;
        for (int i = 0; i < bound; i++) {
            if (first.charAt(i) == second.charAt(i)){
                commonLetters++;
            } else {
                break;
            }
        }
        return first.substring(0, commonLetters);
    }

    public static void main(String[] args) {
        System.out.println(getPrefix("cat", "carrot"));
    }
}
