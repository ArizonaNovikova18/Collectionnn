package pro.sky.collection.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int department;

    public Employee(String firstName, String lastName) {
        Random random = new Random();

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = random.nextInt(10000) + 1000;
        this.department = random.nextInt(5) + 1;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
