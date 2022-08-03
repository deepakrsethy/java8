package streamapi;

import java.util.*;

/**
 * forEach() accepts Consumer functional interface which has a method void accept(T t).
 * It takes an input but does not return anything
 */
public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9);
        values.stream().forEach(s -> System.out.print(s+" "));
        System.out.println();
        values.stream().sorted(Collections.reverseOrder()).forEach(s -> System.out.print(s+" "));


        System.out.println();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");

        map.forEach((key, value) -> System.out.println("Key:"+key+", Value: "+value));
        map.entrySet().stream().forEach((obj) -> System.out.println("Key:"+obj.getKey()+", Value: "+obj.getKey()));


    }
}
