package com.keshavarziparham;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 33);
        Employee parham = new Employee("Parham Keshavarzi", 21);
        Employee jack = new Employee("Jack Hill", 22);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(parham);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        /*
        predicate arguements are lambda expressions that match the predicate interface
         */
        printEmployeesByAge(employees,"Employeees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employess under 30", employee -> employee.getAge() <= 30);

        System.out.println("Employees over 30;");
        System.out.println("==================");

        /*
        Both the loops bellow seem redudant, why not use a single boolean and loop to indicate
        what age range should be displayed? - predicate interface

        test method is a functional method in this case and it accepts a predicate that returns a bool.
        Can replace both conditions (above and below) with predicate
         */
        /*
        Pass the requirement for each method a lambda expression that
        meets the requirement of a consumer interface
         */

//        employees.forEach(employee -> {
//            if(employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });
//
//        System.out.println("\nEmployees 30 and under");
//        System.out.println("=========================");
//        employees.forEach(employee -> {
//            if(employee.getAge() <= 30){
//                System.out.println(employee.getName());
//            }
//        });


        //pass a lambda expression that meets requirements for consumer interface
        //It is called a 'consumer' because it's object in, void out
//        employees.forEach(employee -> {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });
    }


    /*
    if statement is now using the predicate parameter the for loop passes each employee to the predicate
    parameter the for loop passes each employee to the predicate test method which in turn uses the
    employee as a parameter or as the parameter for the lambda expression that maps to the predicate
     */
    private static void printEmployeesByAge(List<Employee> employees, String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
