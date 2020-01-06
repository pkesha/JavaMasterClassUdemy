package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        int maxNumber = 0;
        int minNumber = 0;
        int temp = 0;
        Scanner scanner = new Scanner(System.in);

        //Can do while (true)
        while (true) {
            System.out.println("Please enter number #" + count + ":");
            //Checks for valid type or value
            if(scanner.hasNextInt()){
                count++;    //counter increment
                temp = scanner.nextInt(); //scanning in number as integer

                //first input is automatically assigned to min and max
                minNumber = (count == 1) ? temp : minNumber;
                maxNumber = (count == 1) ? temp : maxNumber;

                //check to see if min or max value against new value
                maxNumber = (maxNumber < temp) ? temp : maxNumber;
                minNumber = (minNumber > temp) ? temp : minNumber;
            } else {
                System.out.println("");
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
        System.out.println("Maximum: " + maxNumber);
        System.out.println("Minimum: " + minNumber);
    }
}