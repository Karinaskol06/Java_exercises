package IntermediateCourse.GenericImplementation;

import java.util.List;
import java.util.ArrayList;

public class Wildcard {
    // Upper-bounded wildcard: Works with a list of Number or any subclass of Number
    public static void upperFunc(List<? extends Number> list) {
        for (Number number : list){
            System.out.println(number);
        }
        System.out.println();
    }

    // Lower-bounded wildcard: Accepts a list of Integer or any superclass of Integer
    public static void lowerFunc(List<? super String> list){
        list.add("Hello");
        System.out.println(list);
        System.out.println();
    }

    // Unbounded wildcard: Works with any list, but only allows reading as Object
    public static void unboundFunc(List<?> list){
        for (Object object : list){
            System.out.println(object);
        }
        System.out.println();
    }

    // Simple generic method: Generic type parameter T
    public static <T> void genericFunc(List<T> list){
        for (T item : list){
            System.out.println(item);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(5, 7, 1, 99, 820);
        upperFunc(list1);

        List<Object> list2 = new ArrayList<>();
        lowerFunc(list2);

        List<String> list3 = List.of("Hello", "World");
        unboundFunc(list3);

        List<String> list4 = List.of("EL", "EL", "EL");
        genericFunc(list4);

    }
}
