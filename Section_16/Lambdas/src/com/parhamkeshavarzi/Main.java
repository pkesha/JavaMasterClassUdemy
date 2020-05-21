package com.parhamkeshavarzi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable");
//            }
//        }).start();

        //Same as code on the top (lambda expression)
//        new Thread(() -> {
//            System.out.println("Printing from the Runnable");
//            System.out.println("Line 2");
//            System.out.format("This is line %d\n", 3);
//        }).start();

        Employee john = new Employee("John Doe", 33);
        Employee parham = new Employee("Parham Keshavarzi", 21);
        Employee jack = new Employee("Jack Hill", 22);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(parham);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees){
            System.out.println(employee.getName());
        }
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



//
//class CodeToRun implements Runnable{
//    @Override
//    public void run() {
//        System.out.println("Printing from  Runnable");
//    }
//}