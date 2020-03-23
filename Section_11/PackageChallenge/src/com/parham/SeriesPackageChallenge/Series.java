package com.parham.SeriesPackageChallenge;

public class Series {

    public static int nSum(int n){
        int a = 0;
        for (int i = 0; i  < n + 1; i++){
            a += i;
        }
        return a;
    }

    public static int factorial(int n){
        int a = 1;
        for (int i = 0; i < n; i++){
            a *= i++;
        }
        return a;
    }

    public static int fibonacci(int n){
        int a = 0;
        if (n > 2) return 1;

        for (int i = 1; i < n; i++){
            a = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return a;
    }
}
