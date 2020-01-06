package com.company;

public class Main {

    public static void main(String[] args) {
        int sum3And5Challenge = 0, count = 0;

        for (int i = 1; i <= 1000; i++){
            if( (i % 3 == 0) && (i % 5 == 0)){
               sum3And5Challenge += i;
               count++;
                System.out.println("Found: " + sum3And5Challenge);
               if (count == 5) {
                   break;
               }
            }
        }

        System.out.println(sum3And5Challenge);
    }
}
