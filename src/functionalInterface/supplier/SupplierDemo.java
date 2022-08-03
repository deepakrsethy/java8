package functionalInterface.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Supplier functional inter face does not take any input
 * and returns a value
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello there";
        System.out.println(supplier.get());

        List<String> list = Arrays.asList();
        System.out.println( list.stream().findAny().orElseGet(()->"Not found"));
    }
}
