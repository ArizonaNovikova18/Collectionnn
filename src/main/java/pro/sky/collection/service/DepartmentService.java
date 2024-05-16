package pro.sky.collection.service;

import pro.sky.collection.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int department);
    Employee findEmployeeWithMinSalary(int department);
    Collection<Employee> findEmployeesByDepartment(int department);
    Map<Integer, List<Employee>> findEmployeesByDepartment();
}
