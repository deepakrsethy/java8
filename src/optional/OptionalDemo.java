package optional;

import streamapi.realtimeUsage.Employee;
import streamapi.realtimeUsage.EmployeeDao;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Employee employee = new Employee(1, null, "D1", 500000);
        Optional<Employee> emptyOptionalEmployee = Optional.empty();
        System.out.println(emptyOptionalEmployee);

        //Optional.of(T t) does Null check and throws NullPointerException.
       // Optional<String> ofEmployeeOptional = Optional.of(employee.getEmployeeName());

        //Optional.ofNullable(T t) returns empty if value is null or returns the original values
        Optional<String> emailOptional = Optional.ofNullable(employee.getEmployeeName());
        System.out.println(emailOptional);

        Optional<String> emailOptional2 = Optional.ofNullable(employee.getEmployeeName());
        if(emailOptional2.isPresent()){
            System.out.println(emailOptional);
        }else{
            System.out.println("Null for email");
        }

        //orElse(T t) : returns default specified value if required value is null
        Optional<String> emailOptional3 = Optional.ofNullable(employee.getEmployeeName());
        // System.out.println(emailOptional3.get());// Throws no such element exception
        System.out.println(emailOptional3.orElse("Null for email"));

        System.out.println(emailOptional3.orElseGet(()->"Null for email"));

        //System.out.println(emailOptional3.orElseThrow());// Throws no such element exception

       // System.out.println(emailOptional3.orElseThrow(()-> new RuntimeException("email not present")));

        System.out.println(emailOptional3.map(s -> s.toUpperCase()).orElseGet(() -> "Default"));
        System.out.println(emailOptional3.map(String :: toUpperCase).orElseGet(() -> "Default"));

        Optional<Employee> employeeOptional = Optional.ofNullable(employee);
        Optional<String> empName = Optional.ofNullable(employeeOptional.get().getEmployeeName());
        System.out.println(empName.orElse("Invalid"));


        System.out.println(getCustomerForId(1122344));



    }

    public static Employee getCustomerForId(int id){
        List<Employee> employeeList = EmployeeDao.getAllEmployees();
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId() == id)
                .findAny().orElseThrow(() -> new RuntimeException("Employee Not found"));
    }
}
