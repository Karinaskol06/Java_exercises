package SimpleSyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForEachTasks {
    public static void main(String[] args) {
//        //task 1
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        list.forEach(e -> System.out.println(e * e));


        List<String> names = Arrays.asList("Karina", "Artem", "Borys", "George", "Ciri");
        names.forEach(name -> {
            if (name.contains("a")) {
                System.out.println(name);
            }
        });
    }
}
