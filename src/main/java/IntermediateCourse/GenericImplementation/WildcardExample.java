package IntermediateCourse.GenericImplementation;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

    // Upper-bounded wildcard: Works with a list of Number or any subclass of Number
    public static void processNumbers(List<? extends Number> list) {
        System.out.println("Upper-bounded wildcard (reading data):");
        for (Number num : list) { // We can read as Number
            System.out.println(num);
        }
        // list.add(10); // Not allowed, can't add to an upper-bounded wildcard
    }

    // Lower-bounded wildcard: Accepts a list of Integer or any superclass of Integer
    public static void addIntegers(List<? super Integer> list) {
        System.out.println("Lower-bounded wildcard (adding data):");
        list.add(10); // Valid
        list.add(20); // Valid
        // Integer x = list.get(0); // Not allowed, only Object can be guaranteed
    }

    // Unbounded wildcard: Works with any list, but only allows reading as Object
    public static void printAll(List<?> list) {
        System.out.println("Unbounded wildcard:");
        for (Object obj : list) { // Can only read as Object
            System.out.println(obj);
        }
        // list.add("Hello"); // Not allowed, can't add anything
    }

    // Simple generic method: Generic type parameter T
    public static <T> void printGeneric(List<T> list) {
        System.out.println("Simple generic method:");
        for (T item : list) {
            System.out.println(item); // Can use T directly
        }
        list.add(list.get(0)); // Can safely add T
    }

    public static void main(String[] args) {
        // Upper-bounded wildcard example
        List<Double> doubles = List.of(1.1, 2.2, 3.3);
        processNumbers(doubles);

        // Lower-bounded wildcard example
        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println(numbers);

        // Unbounded wildcard example
        List<String> strings = List.of("A", "B", "C");
        printAll(strings);

        // Simple generic method example
        List<String> genericStrings = new ArrayList<>(List.of("X", "Y", "Z"));
        printGeneric(genericStrings);
        System.out.println(genericStrings);
    }
}
