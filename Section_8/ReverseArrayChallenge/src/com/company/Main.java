package com.company;

import javax.swing.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter number of elements: ");
        int element = scanner.nextInt();

        int[] reverseArray = new int[element];
        reverseArray = getArray(reverseArray);

        reverseArrayMethod(reverseArray);


    }

    private static int[] getArray(int[] reverseArray){
        for(int i = 0; i < reverseArray.length; i++){
            System.out.println("Enter value for element " + i + ":");
            reverseArray[i] = scanner.nextInt();
        }
        return reverseArray;
    }

    private static void reverseArrayMethod(int[] array){
        System.out.println("Non-reversed array: " + Arrays.toString(array));
        int temp = 0;

        for (int j = 0; j < (array.length/2); j++){
            temp = array[j];
            array[j] = array[array.length - 1 - j];
            array[array.length - 1 - j] = temp;
        }

        System.out.println("Reversed Array: " + Arrays.toString(array));
    }
}
