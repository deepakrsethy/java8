package functionalInterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate functional interface takes conditional argument as input
 * and returns boolean
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x%2 == 0;
        System.out.println(predicate.test(10));

        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9);
        values.stream().filter(x -> x%2 == 0).forEach(x-> System.out.println(x));

    }
}
