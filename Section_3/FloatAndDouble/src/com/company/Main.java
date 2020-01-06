package com.company;

public class Main {

    public static void main(String[] args) {

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float minimum value = " + myMinFloatValue);
        System.out.println("Float maximum value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double minimum value = " + myMinDoubleValue);
        System.out.println("Double maximum value = " + myMaxDoubleValue);

        int myIntValue = 5/2;
        float myFloatValue = 5f/3f; //f indicates a floating point number
        double myDoubleValue = 5.00 / 3.00;   //d indicates a double point number
        System.out.println("MyIntValue = " + myIntValue);
        System.out.println("MyFloatValue = " + myFloatValue);
        System.out.println("MyDoubleValue = " + myDoubleValue);

        double lbs = 5d;
        double kg = lbs * 0.45359237d;
        System.out.println(kg + " Kilograms");

        double pi = 3.1415927d;
        double anotherNumber = 3_000.5_1_2d;
        System.out.println("pi");

    }
}
