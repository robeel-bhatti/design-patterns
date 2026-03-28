package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private String name;

    private String role;

    private double salary;

    private List<Employee> employees = new ArrayList<>();

    public Manager(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public double getTotalCost() {
        double total = this.salary;
        for (Employee employee : employees) {
            total += employee.getTotalCost();
        }
        return total;
    }

    @Override
    public int getHeadcount() {
        int total = 1;

        // The employee here can be
        // a manager or IC, it doesn't matter
        // because both have the same interface
        // and methods so it's safe to call on whoever.
        for (Employee employee : employees) {
            total += employee.getHeadcount();
        }
        return total;
    }

    @Override
    public void print(int indent) {
        System.out.println(" ".repeat(indent * 2) + getRole() + " - " + getName() + " (salary: " + getSalary() + ")");
        for (Employee employee : employees) {
            employee.print(indent + 1);
        }
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }
}
