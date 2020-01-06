package com.company;

public class Main {

    public static void main(String[] args) {
        /*System.out.println("10K @ 2% interest = " + calculateInterest(10000.0, 2.0));
        System.out.println("10K @ 3% interest = " + calculateInterest(10000.0, 3.0));
        System.out.println("10K @ 4% interest = " + calculateInterest(10000.0, 4.0));
        System.out.println("10K @ 5% interest = " + calculateInterest(10000.0, 5.0));*/

        //For loop calling a method
        for(int i = 2; i < 9; i++){
            System.out.println("10k @ " + i + "% interest = " + /*String.format("%.2f",*/
                    calculateInterest(10000.0f, i));
        }

        System.out.println(" ");    //Seperating

        //For loop in reverse
        for(int i = 8; i > 1; i--){
            System.out.println("10k @ " + i + "% interest = " + /*String.format("%.2f",*/
                    calculateInterest(10000.0f, i));
        }

        int count = 0;
        for(int i = 1; i <= 50; i++) {
            if (isPrime(i)){
                System.out.println(i + " is a prime number");
                count++;
                if (count == 3){
                    System.out.println("3 prime numbers found. Exiting loop");
                    break;
                }
            } else {
                //
                // System.out.println(i + " is not a prime number");
            }
        }
    }

    public static boolean isPrime(int n){
        if (n == 1) {
            return false;
        }

        //Doing Math.sqrt instead of n/2 is faster
        for(int i = 2; i <= (n/2); i++){
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static float calculateInterest(float amount, float interestRate){
        return (amount * (float)(interestRate*0.01));
    }
}
