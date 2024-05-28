package pro.sky.collection.service;

import ch.qos.logback.core.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.collection.exception.EmployeeAlreadyAddException;
import pro.sky.collection.exception.EmployeeNotFoundException;
import pro.sky.collection.exception.EmployeeStorageIsFullException;
import pro.sky.collection.model.Employee;

import java.util.*;

@Service
public class EmployeeService {
    private final int maxEmployee = 10;
    private final Map<String, Employee> employees = new HashMap<>();
    private final ValidationService validationService;
    public EmployeeService(ValidationService validationService){
        this.validationService = validationService;
    }

    public Employee add(String firstName, String lastName, int department, int salary){
        firstName = validationService.checkName(firstName);
        lastName = validationService.checkName(lastName);
        String key = buildKey(firstName, lastName);
if (employees.containsKey(key)){
    throw new EmployeeAlreadyAddException();
}
if (employees.size() >= maxEmployee){
    throw new EmployeeStorageIsFullException();
}
Employee employee = new Employee(firstName, lastName, department, salary);
employees.put(key, employee);
return employee;
    }
    public Employee remove(String firstName, String lastName){
String key = buildKey(firstName, lastName);
if (!employees.containsKey(key)){
    throw new EmployeeNotFoundException();
}
return employees.remove(key);
    }
    public Employee find(String firstName, String lastName){
        String key = buildKey(firstName, lastName);
        if (!employees.containsKey(key)){
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    private String buildKey(String name, String surname){
        return name + surname;
    }

    public List<Employee> findAll(){
        return List.copyOf(employees.values());
    }

}
