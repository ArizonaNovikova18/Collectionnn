package pro.sky.collection.service;

import pro.sky.collection.exception.EmployeeNotFoundException;
import pro.sky.collection.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    public Employee findEmployeeWithMaxSalary(int department) {
      return employeeService.findAll().stream()
              .filter(employee -> employee.getDepartment()==department)
              .max(Comparator.comparingInt(Employee::getSalary))
              .orElseThrow(()-> new EmployeeNotFoundException());
    }
public Employee findEmployeeWithMinSalary(int department) {
    return employeeService.findAll().stream()
            .filter(employee -> employee.getDepartment()==department)
            .min(Comparator.comparingInt(Employee::getSalary))
            .orElseThrow(()-> new EmployeeNotFoundException());
}
public List<Employee> findEmployeesByDepartment(int department) {
    return employeeService.findAll().stream()
            .filter(employee -> employee.getDepartment()==department)
            .collect(Collectors.toList());
}
public Map<Integer, List<Employee>> groupEmployeeByDepartment(){
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
}
}
