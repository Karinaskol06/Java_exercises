package SimpleSyntax.Strings;

import java.util.stream.Stream;

public class ReverseString {

    public static String reverseStringBuilder(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String reverseString(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--){
            reversed = reversed + input.charAt(i);
        }
        return reversed;
    }

    public static String stringBuilderUndercover(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Stream.iterate(input.length() - 1, n -> n - 1)
                .limit(input.length())
                .forEach(n -> stringBuilder.append(input.charAt(n)));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStringBuilder("Hello World"));
        System.out.println(reverseString("Hello World"));
        System.out.println(stringBuilderUndercover("Hello World"));
    }
}
