package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);

        System.out.println("The average is " + getAverage(myIntegers));


        /*int[] myIntArray = new int[25];
        *//*myIntArray[0] = 45;
        myIntArray[1] = 476;
        myIntArray[5] = 50;*//*

        printArray(myIntArray);

    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = i * 10;
            System.out.println("Element " + i + ", value is " + array[i]);
        }*/
    }

    public static int[] getIntegers(int numbers){
        System.out.println("Enter " + numbers + " integer values. \r");
        int[] values = new int[numbers];

        for(int i = 0; i < values.length; i++){
            values[i] = scanner.nextInt();
            System.out.println("Element " + i + ", value is " + values[i]);
        }

        return values;
    }

    public static double getAverage(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }

        return (double) sum / (double) array.length;
    }
}
