package dao;

import java.util.List;
import entity.Employee;

public interface EmployeeDao {
    int addEmployee(Employee employee);
    int isEmployee(String username);
    List<Employee> getEmployees();
    int delEmployee(String username);
    Employee getEmployeeByUsername(String username);
    int updateEmp(Employee employee);
}
