package com.keshavarziparham;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 33);
        Employee parham = new Employee("Parham Keshavarzi", 21);
        Employee jack = new Employee("Jack Hill", 22);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(parham);
        employees.add(jack);
        employees.add(snow);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }
}
