package pro.sky.collection.service;

import org.springframework.stereotype.Service;
import pro.sky.collection.exception.EmployeeAlreadyAddException;
import pro.sky.collection.exception.EmployeeNotFoundException;
import pro.sky.collection.exception.EmployeeStorageIsFullException;
import pro.sky.collection.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final int maxEmployee = 10;
    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String lastName){
Employee employee = new Employee(firstName, lastName);
if (employees.contains(employee)){
    throw new EmployeeAlreadyAddException();
}
if (employees.size() >= maxEmployee){
    throw new EmployeeStorageIsFullException();
}
employees.add(employee);
return employee;
    }
    public Employee remove(String firstName, String lastName){
Employee employee = new Employee(firstName, lastName);
if (!employees.contains(employee)){
    throw new EmployeeNotFoundException();
}
employees.remove(employee);
return employee;
    }
    public Employee find(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    public List<Employee> findAll(){
        return Collections.unmodifiableList(employees);
    }

}
