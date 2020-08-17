package com.keshavarziparham;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;
import java.util.function.*;

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

        //When returning a value for lambdas curly braces are required
        //Generic function. Argument type is employee, return type is string
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(1));
        //System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for(Employee employee : employees){
            if(random1.nextBoolean()){
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World");

        /*  L298
        printEmployeesByAge(employees, "Employees over 30", employee ->
                employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees 30 and under",
                employee ->  employee.getAge() <= 30);


        //predicate arguments are lambda expressions that match the predicate interface
        printEmployeesByAge(employees,"Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees under 30", employee -> employee.getAge() <= 30);
        //Anonymous class
        printEmployeesByAge(employees, "\nEmployees younger than 25",
                new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        //Left of arrow is argument, right side is statement (the statements would then override)
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a+5));
        //True if all predicates return true.  Each variable is within the scope of a single lambda.
        //This is why it's okay to use the same name
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt();
        for(int i = 0; i < 10; i++){
            System.out.println(random.nextInt(1000));
        }
        employees.forEach( employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last name is: " + lastName);
        });*/

        /* L296 - deleted
        System.out.println("Employees over 30;");
        System.out.println("==================");


        Both the loops bellow seem redudant, why not use a single boolean and loop to indicate
        what age range should be displayed? - predicate interface

        test method is a functional method in this case and it accepts a predicate that returns a bool.
        Can replace both conditions (above and below) with predicate
         */

        /* L296

        //Pass the requirement for each method a lambda expression that
        //meets the requirement of a consumer interface

        employees.forEach(employee -> {
            if(employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });

        System.out.println("\nEmployees 30 and under");
        System.out.println("=========================");
        employees.forEach(employee -> {
            if(employee.getAge() <= 30){
                System.out.println(employee.getName());
            }
        });

        //pass a lambda expression that meets requirements for consumer interface
        //It is called a 'consumer' because it's object in, void out
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
        */
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
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
