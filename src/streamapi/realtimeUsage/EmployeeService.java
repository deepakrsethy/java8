package streamapi.realtimeUsage;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;
    List<Employee> findEligibleEmployeeForTaxDeduction(int threshold){
        employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.getAllEmployees();
        return employees.stream().filter(employee -> employee.getSalary()>threshold ).toList();
    }

    public List<Employee> findAllEmployees() {
        employeeDao = new EmployeeDao();
        return employeeDao.getAllEmployees();
    }
}
