package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        int sumTenNumbers = 0;
        int temp = 0;
        Scanner scanner = new Scanner(System.in);

        //Can do while (true)
        while (count < 10) {
            System.out.println("Please enter number #" + count + ":");
            if(scanner.hasNextInt()){
                count++;
                temp = scanner.nextInt();
                sumTenNumbers += temp;
            } else {
                System.out.println("Invalid Number");
            }

            scanner.nextLine();
        }
        scanner.close();
        System.out.println("Number total: " + sumTenNumbers);
    }
}