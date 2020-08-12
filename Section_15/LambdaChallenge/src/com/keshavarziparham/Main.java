package com.keshavarziparham;

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

    }


    //Challenge 4; right challenge 3 but pass it to a method
    //Instead of hardcoding, use anoter argument called source
    public static String everySecondCharacter(Function<String, String> func, String pass){
        return func.apply(pass);
    }



}
