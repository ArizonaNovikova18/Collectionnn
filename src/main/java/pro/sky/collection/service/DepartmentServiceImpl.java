package pro.sky.collection.service;

import org.springframework.stereotype.Service;
import pro.sky.collection.exception.EmployeeNotFoundException;
import pro.sky.collection.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

public DepartmentServiceImpl(EmployeeService employeeService){
    this.employeeService = employeeService;
}

    @Override
    public Employee findEmployeeWithMaxSalary(int department){
       return employeeService.findAll().stream()
               .filter(e -> e.getDepartment() == department)
               .max(comparingInt(e -> e.getSalary()))
               .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department){
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparingInt(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int department){
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment(){
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
