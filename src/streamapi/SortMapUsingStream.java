package streamapi;

import streamapi.realtimeUsage.Employee;

import java.util.*;

public class SortMapUsingStream {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "ab");
        map.put(3, "caz");
        map.put(2, "ca");
        map.put(4, "abc");

        System.out.println("sort the map using traditional approach");
        ArrayList<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, ((o1, o2) -> o1.getKey().compareTo(o2.getKey())));
        list.forEach(s -> System.out.println(s));


        System.out.println("sort the map using stream approach");
        System.out.println("sort the map using stream approach: comparing by key");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(s -> System.out.println(s));
        System.out.println("sort the map using stream approach: comparing by value");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(s -> System.out.println(s));

        System.out.println("sort the map using stream approach: comparing by key in reverse order");
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).forEach(s -> System.out.println(s));


        System.out.println("Sort Map of derived type Key");
        List<Employee> employees = getAllEmployees();
        int size = employees.size();
        Map<Employee, Integer> employeeIntegerMap = new HashMap<>();
        for(Employee e : employees){
            employeeIntegerMap.put(e, size--);
        }

        System.out.println("Sort Map of derived type Key: Using conventional approach according salary field");
        List<Map.Entry<Employee, Integer>> empList = new ArrayList<>(employeeIntegerMap.entrySet());
        Collections.sort(empList, new Comparator<Map.Entry<Employee, Integer>>() {
            @Override
            public int compare(Map.Entry<Employee, Integer> o1, Map.Entry<Employee, Integer> o2) {
                return o1.getKey().getSalary() - o2.getKey().getSalary();
            }
        });
        //or
        Collections.sort(empList,(o1, o2) -> o1.getKey().getSalary() - o2.getKey().getSalary());
        employeeIntegerMap.entrySet().stream().sorted((o1, o2) -> o1.getKey().getSalary() - o2.getKey().getSalary())
                .forEach(o -> System.out.println(o.getKey()));
        System.out.println("Sort Map of derived type Key: Using conventional approach according employeename field");
        employeeIntegerMap.entrySet().stream().sorted((o1, o2) -> o1.getKey().getEmployeeName().compareTo(o2.getKey().getEmployeeName()))
                .forEach(o -> System.out.println(o.getKey()));

        employeeIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)))
                .forEach(System.out::println);
        employeeIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
                .forEach(System.out::println);

    }

    public static List<Employee> getAllEmployees(){
        Employee e1 = new Employee(123, "John", "D1", 467000);
        Employee e2 = new Employee(167, "Paul", "D2", 567000);
        Employee e3 = new Employee(311, "Harry", "D1", 1467000);
        Employee e4 = new Employee(177, "John", "D6", 487000);
        return Arrays.asList(e1, e2, e3, e4);
    }
}
