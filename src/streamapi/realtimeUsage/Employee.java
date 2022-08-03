package streamapi.realtimeUsage;

/**
 * Find all the employees who are eligible to pay tax
 * If an employee recieves salary more than 500000 then he is eligible to pay tax
 */
public class Employee {
    int employeeId;
    String employeeName;
    String deptId;
    int salary;

    public Employee(int employeeId, String employeeName, String deptId, int salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.deptId = deptId;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDeptId() {
        return deptId;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", deptId='" + deptId + '\'' +
                ", salary=" + salary +
                '}';
    }
}
