package SimpleSyntax.Strings;

import java.util.ArrayList;
import java.util.List;

public class SuffixesAndPrefixes {

    public static List<String> getSuffixes(String input) {
        ArrayList<String> suffixes = new ArrayList<>();
        for (int i = input.length() - 1; i >= 0; i--){
            suffixes.add(input.substring(i));
        }
        return suffixes;
    }

    public static List<String> getPrefixes(String input){
        ArrayList<String> prefixes = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            prefixes.add(input.substring(i));
        }
        return prefixes;
    }
    public static void main(String[] args) {
        System.out.println(getSuffixes("Hello World"));
        System.out.println(getPrefixes("Hello World"));
    }
}
