package streamapi;

import java.util.*;

public class SortListUsingStream {
    static class Customer {
        int id;
        String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Integer> primitives = new ArrayList<>();
        primitives.add(9);
        primitives.add(2);
        primitives.add(5);
        primitives.add(7);
        primitives.add(6);
        primitives.add(1);
        System.out.println("Primitives Before sorting ");
        primitives.stream().forEach(i -> System.out.println(i+" "));


        System.out.println("Primitives sorted using conventional approach ");
        Collections.sort(primitives /*, Collections.reverseOrder()*/);
        //Collections.sort(primitives, Comparator.reverseOrder());
        //Collections.reverseOrder();
        primitives.stream().forEach(i -> System.out.println(i+" "));

        List<Integer> primitivesStream = new ArrayList<>();
        primitivesStream.add(9);
        primitivesStream.add(2);
        primitivesStream.add(5);
        primitivesStream.add(7);
        primitivesStream.add(6);
        primitivesStream.add(1);
        System.out.println("Primitives Before sorting ");
        primitivesStream.stream().forEach(i -> System.out.println(i+" "));
        System.out.println("Primitives sorted using stream ");
        primitivesStream.stream().sorted().forEach(i -> System.out.println(i+" "));
        System.out.println("Primitives sorted using stream in reverse order");
        primitivesStream.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.println(i+" "));

        Customer c1 = new Customer(3, "Deepak");
        Customer c2 = new Customer(1, "Ranjan");
        Customer c3 = new Customer(2, "Sethy");

        List<Customer> customers = Arrays.asList(c1, c2, c3);

        System.out.println("Derived type list Before sorting ");
        customers.stream().forEach(c -> System.out.println(c));
        System.out.println("Derived type sorted using conventional approach ");
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.id - o2.id;
            }
        });

        customers.stream().forEach(c -> System.out.println(c));

        System.out.println("Derived type sorted using stream : Type1 ");
       customers.stream().sorted(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
               return o1.id -  o2.id ;
            }
        }).forEach(c -> System.out.println(c));
        //or simply
        System.out.println("Derived type sorted using stream : Type2 ");
        customers.stream().sorted((o1, o2) -> o1.id -  o2.id).forEach(c -> System.out.println(c));
        System.out.println("Derived type sorted using stream in reverse order : Type3 ");
        customers.stream().sorted((o1, o2) -> o2.id -  o1.id).forEach(c -> System.out.println(c));


    }
}
