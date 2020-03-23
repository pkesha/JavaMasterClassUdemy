package com.company;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        while(count != 6){
            System.out.println("Count value is " + count);
            count++;
        }

        while (true) {
            if (count == 5) {
                break;
            }
            System.out.println("While count value is " + count);
            count++;
        }

        count = 6;
        do {
            System.out.println("Count value was " + count);
            count++;

            if(count > 100){
                break;
            }

        } while (count != 6);

        int number = 4;
        int finishNumber = 20;
        count = 0; int sum = 0;
        while (number <= finishNumber){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            System.out.println("Even number " + number);

            sum += number;
            count++;
            if (count == 5){
                System.out.println("Sum of first 5 even numbers in range: " + sum);
                System.out.println("Found " + count + " even numbers");
                break;
            }
        }
    }

    public static boolean isEvenNumber(int number){
        if((number % 2) == 2){
            return true;
        } else {
            return false;
        }
    }
}
