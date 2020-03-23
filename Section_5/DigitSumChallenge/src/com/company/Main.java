package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumDigits(-125));
    }

    public static int sumDigits(int number){
        int n = number;
        int sum = 0;
        if (number >= 10){
            while (n != 0){
                sum += n % 10;
                n /= 10;
            }
        } else {
            sum = -1;
        }
        return sum;
    }
}
