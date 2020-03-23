package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        printArray(sortArray(getIntegers(5)));
    }

    public static int[] getIntegers(int number){
        Scanner scanner = new Scanner(System.in);
        int[] sortNumbers;
        sortNumbers = new int[number];

        for (int i = 0; i < number; i++){
            System.out.println("Enter value for element " +
                    i + ": \r");
            sortNumbers[i] = scanner.nextInt();
        }
        return sortNumbers;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Element " + i + " has the value " +
                    array[i]);
        }
    }

    public static int[] sortArray(int[] array){

        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                int temp = array[i];
                if(temp < array[i+1]){
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }

        return array;
    }
}
