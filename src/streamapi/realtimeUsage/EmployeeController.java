package streamapi.realtimeUsage;

import java.util.List;

public class EmployeeController {
    private static final int THRESHOLD = 500000;
    private EmployeeService employeeService;

   public List<Employee> findTaxableEmployees(int threshold){
        employeeService = new EmployeeService();
        return employeeService.findEligibleEmployeeForTaxDeduction(threshold);
    }

    public List<Employee> findAllEmployees(){
        employeeService = new EmployeeService();
        return employeeService.findAllEmployees();
    }

    public static void main(String[] args) {
       EmployeeController controller = new EmployeeController();
        System.out.println("ALl Employees");
        controller.findAllEmployees().forEach(x -> System.out.println(x));
        System.out.println("ALl Employees eligible for tax");
        new EmployeeController().findTaxableEmployees(THRESHOLD).forEach(x -> System.out.println(x));
    }
}
