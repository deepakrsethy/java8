package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMapDemo {
    static class Employee {
        int id;
        String name;
        String emailId;
        List<Integer> phoneNumbers;

        public Employee(int id, String name, String emailId, List<Integer> phoneNumbers) {
            this.id = id;
            this.name = name;
            this.emailId = emailId;
            this.phoneNumbers = phoneNumbers;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmailId() {
            return emailId;
        }

        public List<Integer> getPhoneNumbers() {
            return phoneNumbers;
        }
    }

    public static List<Employee> getAllEmployees(){
        Employee e1 = new Employee(1, "Deepak", "deepak@abc.com", Arrays.asList(1234, 4567));
        Employee e2 = new Employee(2, "Ranjan", "ranjan@abc.com", Arrays.asList(56789, 76890));
        Employee e3 = new Employee(3, "Sethy", "sethy@abc.com", Arrays.asList(88996, 3425432));
        return Arrays.asList(e1, e2, e3);
    }

    public static void main(String[] args) {
        List<Employee> employees = getAllEmployees();
        List<String> collect = employees.stream()
                .map(employee -> employee.getEmailId())
                .collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> collect2 = employees.stream()
                .flatMap(employee -> employee.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(collect2);
    }
}
