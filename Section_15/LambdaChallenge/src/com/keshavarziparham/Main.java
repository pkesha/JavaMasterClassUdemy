package com.keshavarziparham;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //Challenge 1
        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts){
                System.out.println(part);
            }
        };

        //Challenge 2
        //Lambda is taking argument of method, and the body is the method
        //Maps to java.util.function package since it passes and returns a value
        /*Don't have to declare it as String because it's a function definition &
        since it's inferred as a String in the block code*/
        Function<String, String> lambdaFucntion = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if (i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        //Challenge 3:
        //Print out function results with lambdaFunction.appl
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                //Remove if statement here
                if(i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(lambdaFucntion.apply("123456789"));

        //Challenge 5
        System.out.println(everySecondCharacter(lambdaFucntion, "123456789"));

        //Challenge 6: Maps to java.util.Supplier interface
        //Supplier<String> iLoveJava = () -> "I love Java";
        Supplier<String> iLoveJava = () -> {return "I love Java";};

        //Challenge 7: Use supplier
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        //Challenge 9: Sort baby names by first letter and also capitalize the beginning letter
        List<String> topNames2015 = Arrays.asList(
                "Name 1",
                "bame 3",
                "ame 0",
                "zame 9"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach(name -> firstUpperCaseList.add(name.substring(0, 1).toUpperCase() +
//                name.substring(1)));
        //firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        //firstUpperCaseList.forEach(s -> System.out.println(s));

        //Challenge 10:
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        //Challenge 11: Do the same as challenge 9 using streams & chains
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //Challenge 12: Print out how many names being with the letter 'A'
        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();

        //Challenge 13: Use peek, after map method is executed in challenge 12
        //No terminal op, so nothing will show
        //Not sorted because it's done after peek
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .count();


    }


    //Challenge 4; right challenge 3 but pass it to a method
    //Instead of hardcoding, use anoter argument called source
    public static String everySecondCharacter(Function<String, String> func, String pass){
        return func.apply(pass);
    }



}
