package parallelStreams;

import streamapi.realtimeUsage.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParraletStreamDemoWithDerived {
    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;

        List<Employee> employees = createTenThousandEmployees();

        startTime = System.currentTimeMillis();
        double avg1 = employees.stream().map(Employee::getSalary).mapToInt(Integer::intValue).average().getAsDouble();
        endTime = System.currentTimeMillis();
        System.out.println("Execution time with normal stream: "+(endTime-startTime)+" for calculating avg: "+avg1);


        startTime = System.currentTimeMillis();
        double avg2 = employees.stream().parallel().map(Employee::getSalary).mapToInt(Integer::intValue).average().getAsDouble();
        endTime = System.currentTimeMillis();
        System.out.println("Execution time with parallel stream: "+(endTime-startTime)+" for calculating avg: "+avg2);


    }

    private static List<Employee> createTenThousandEmployees() {
        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i<= 1000000; i++ ){
            employees.add(new Employee(i, "Employee"+i, "D1", Integer.valueOf(new Random().nextInt(1000*100)) ));
        }
        return employees;
    }
}
