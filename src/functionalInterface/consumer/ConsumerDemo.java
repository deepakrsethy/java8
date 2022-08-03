package functionalInterface.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer functional interface takes one input and does not return anything.
 */
public class ConsumerDemo{

    public static void main(String[] args) {
        Consumer c = x -> System.out.println("Print :"+x);
        c.accept(10);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().forEach(c); //internally calls the accept method of consumer
        list.stream().forEach(x -> System.out.println("Print :"+x)); // directly pass the lambda instead of the reference
    }
}
