package SimpleSyntax;

import java.util.*;

public class OddNumsSum {
    public static int getOddNumsSum(List<Integer> list){
        int sum = 0;
        for (Integer i : list){
            if (i % 2 == 0){
                sum += 1;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 5, 7, 9, 0, 10, 32, 1, 5, 3, 8);
        System.out.println(getOddNumsSum(list));

        Set<Integer> set = new HashSet<>(list);
        //set.addAll(list);
        System.out.println(set);
    }

}
