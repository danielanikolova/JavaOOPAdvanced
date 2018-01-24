package p03_employee_info.user_interfaces;

import p03_employee_info.models.Employee;

import java.util.List;

public interface InfoProvider {
    List<Employee> getEmployeesByName();
    List<Employee> getEmployeesBySalary();
}
