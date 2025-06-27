package AlgorithmsJava;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class HashMapCourse {
    public static void main(String[] args) {
        //creating a list of integers, filling it with random numbers
        List<Integer> myInts = new ArrayList<>();
        Random random = new Random();
        for(int i =0; i < 20; i++) {
            myInts.add(random.nextInt(5));
        }
        System.out.println("myInts: " + myInts);

        //initializing map with numbers from the random list
        Map<Integer, Integer> intCount = countNumbers(myInts);
        for(Map.Entry<Integer, Integer> entry: intCount.entrySet()) {
            System.out.println("Integer: "+ entry.getKey()+" appears: "+ entry.getValue());
        }
    }

    public static Map<Integer, Integer> countNumbers(List<Integer> list) {
        Map<Integer, Integer> intCount = new HashMap<>();

        for (Integer integer : list) {
            if (intCount.get(integer) == null) {
                intCount.put(integer, 1);
            } else {
                intCount.put(integer, intCount.get(integer) + 1);
            }
        }
        return intCount;
    }
}