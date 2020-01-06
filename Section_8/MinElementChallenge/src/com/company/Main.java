package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many elements? \r");
        int elements = scanner.nextInt();

        int[] minArray = new int[elements];
        minArray = readIntegers(minArray);

        findMin(minArray);
    }

    private static void findMin(int[] array){
        int minValue = array[0];
        for (int i = 0; i < Array.getLength(array) - 1; i++){
            minValue = (minValue > array[i+1]) ? array[i+1] : minValue;
        }
        System.out.println("Minimum Value: " + minValue);
    }

    private static int[] readIntegers(int[] array){

        for (int i = 0; i < Array.getLength(array); i++){
            System.out.println("Enter value for element " + i + ":");
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
