package com.keshavarziparham;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        //Populating list
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();

        //L300 - Streams
//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")) {
//                //gNumbers needs to be final
//                //reference to gNumbers is final, gNumbers is effectively  final.
//                gNumbers.add(number);
//                //System.out.println(number);
//            }
//        });

//        //Now to sort gNumbers
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        someBingoNumbers
                //Stream pipeline is created.  Contains all the items in someBingoNumbers list, in same order
                .stream()
                //Stream pipeline contains the list with all #s uppercase
                //Mapping a String to an uppercase method to function.
                //.map(s->s.startsWith("G")
                .map(String::toUpperCase)
                //Stream pipeline will contain all items beginning with "G"
                //filter method will only get Strings with "G"
                //Require predicate
                .filter(s->s.startsWith("G"))
                //Stream containing sorted items
                .sorted()
                //Each G item is printed to console, void result. Chain ends here
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "027");
        Stream<String> intNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "071");
        //concat is static, but concatStream can be used as source for a stream
        Stream<String> concatStream = Stream.concat(ioNumberStream, intNumberStream);
        System.out.println("----------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        //String upperString = myString.toUpperCase();
        //String upperString = toUpperCaseString(myString);

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        //L302
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                //This vs of the collect method maps the collector to the arguments required by
//                //the second vs of the method which accepts or expects 3 arguments:
//                //supplier, a bi consumer accumulator, and bi consumer combiner
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                //1st argument is the supplier 2nd argument is accumulator, 3rd argument is the combiner.
                //Accumulator is used when the runtime needs to add a single version or single item into the list
                //Accumulator is used when the runtime needs to add a single item to into a result
                //Combiner is used when
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for(String s : sortedGNumbers){
            System.out.println(s);
        }

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                //Returns youngest employee - reduces stream size
                .reduce((r1,r2) -> r1.getAge() < r2.getAge() ? r1 : r2)
                //prints the smallest result
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    //As long as we return a predicate, we can still execute other code in a lambda
                    //If there is no terminal op, this will not run.
                    //^Lazily evaluated
                    System.out.println(s);
                    return s.length() == 3;
                })
                //Terminal operator so that lambda expression will be evaluated
                .count();


    }
}
