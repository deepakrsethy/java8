package mapReduce;

import streamapi.realtimeUsage.Employee;
import streamapi.realtimeUsage.EmployeeDao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer>  list = Arrays.asList(1, 11, 3, 24, 5, 6, 18 );

        int sum = 0;
        for(int n : list){
            sum = sum+n;
        }
        System.out.println(sum);

        System.out.println(list.stream().mapToInt(Integer::intValue).sum());

        int sum2 = list.stream().reduce(0,(a,b) -> a+b);
        System.out.println(sum2);

       Optional<Integer> sum3 =  list.stream().reduce(Integer::sum);
        System.out.println(sum3.get());

        int product = list.stream().reduce(1, (a,b)->a*b);
        System.out.println(product);
        System.out.println("Max:"+ list.stream().mapToInt(Integer::intValue).max().getAsInt());
        System.out.println("Max using reduce: "+list.stream().reduce(Integer::max).get());
        System.out.println("Min: "+list.stream().mapToInt(Integer::intValue).min().getAsInt());
        System.out.println("Min using reduce: "+list.stream().reduce(Integer::min).get());
        System.out.println("Average: "+list.stream().mapToInt(Integer::intValue).average().getAsDouble());

        List<String> strings = Arrays.asList("aa", "aavsddf", "asdasdasdas", "das");
        String s = strings.stream().reduce((s1, s2) -> s1.length()>s2.length()?s1:s2).get();
        System.out.println(s);

        List<Employee> employees = EmployeeDao.getAllEmployees();
        Double d = employees.stream()
                .filter(employee -> employee.getDeptId().equalsIgnoreCase("D1"))
                .map(employee -> employee.getSalary())
                .mapToInt(Integer::intValue)
                .average().getAsDouble();
        System.out.println(d);
    }
}
