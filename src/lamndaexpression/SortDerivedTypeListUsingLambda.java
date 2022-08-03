package lamndaexpression;

import java.util.*;

public class SortDerivedTypeListUsingLambda {
    static class Customer{
        int id;
        String name;
        int transactionValue;

        public Customer(int id, String name, int transactionValue) {
            this.id = id;
            this.name = name;
            this.transactionValue = transactionValue;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getTransactionValue() {
            return transactionValue;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", transactionValue=" + transactionValue +
                    '}';
        }
    }

    public static void main(String[] args) {
        Customer c1 = new Customer(2, "Deepak", 100);
        Customer c2 = new Customer(3, "Ranjan", 600);
        Customer c3 = new Customer(2, "Deepak", 250);
        Customer c4 = new Customer(1,"Sethy", 400 );
        List<Customer> customers = Arrays.asList(c1, c2, c3, c4);


        System.out.println("Customers");
        customers.stream().forEach(c -> System.out.println(c));



        List<Customer> topNCustomer = findTopNCustomers(customers, 2);
        System.out.println("Top 2 Customers with highest spending");
        topNCustomer.stream().forEach(c -> System.out.println(c));

    }

    private static List<Customer> findTopNCustomers(List<Customer> customers, int top ) {
        if(customers.size() < top){
            throw new RuntimeException("Customer list is smaller to find top "+top);
        }
        List<Customer> uniqueCustomers = createUniqueCustomerList(customers);
        System.out.println("Unique Customers");
        uniqueCustomers.stream().forEach(c -> System.out.println(c));

        List<Customer> sortedCustomer = uniqueCustomers.stream().sorted(
                (c1, c2) -> c2.getTransactionValue()-c1.transactionValue).toList();
        List<Customer> topNCustomer = sortedCustomer.subList(0,top);

        return topNCustomer;
    }

    private static List<Customer> createUniqueCustomerList(List<Customer> customers) {
        List<Customer> uniqueCustomers = new ArrayList<>();
        Map<Integer, Customer> map = new HashMap<>();
        for(Customer c: customers){
            if(map.containsKey(c.id)){
                Customer customer = map.get(c.getId());
                int oldTransValue = customer.getTransactionValue();
                int newTransValue = oldTransValue+c.getTransactionValue();
                Customer updatedCustomer = new Customer(customer.getId(), customer.getName(), newTransValue);
                map.put(customer.getId(), updatedCustomer);
            }else {
                map.put(c.getId(), c);
            }
        }
        for(Customer c : map.values()){
            uniqueCustomers.add(c);
        }

        return uniqueCustomers;

    }
}
