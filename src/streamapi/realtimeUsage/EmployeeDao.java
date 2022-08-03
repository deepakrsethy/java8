package streamapi.realtimeUsage;

import java.util.Arrays;
import java.util.List;

public class EmployeeDao {
    public static List<Employee> getAllEmployees(){
        Employee e1 = new Employee(123, "null", "D1", 467000);
        Employee e2 = new Employee(167, "Paul", "D2", 567000);
        Employee e3 = new Employee(311, "Harry", "D1", 1467000);
        Employee e4 = new Employee(177, "John", "D6", 487000);
        return Arrays.asList(e1, e2, e3, e4);
    }
}
