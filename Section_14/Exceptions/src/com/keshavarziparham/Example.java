package com.keshavarziparham;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        try{
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }
        int result = divide();
        System.out.println(result);
    }

    private static int divide(){
        int x, y;
        //try {
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
//        } catch (NoSuchElementException e){
//            throw new ArithmeticException("No suitable input");
//        } catch (ArithmeticException e){
//            throw new ArithmeticException("Attempt to divide by zero");
//        }
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        while(true){
            try {
                return Integer.parseInt(s.nextLine());
            } catch (InputMismatchException e){
                //No such element wasn't caught
                //Go round again, read past the end of line in the input first
                s.nextInt();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }
    }
}
