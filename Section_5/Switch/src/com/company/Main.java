package com.company;

public class Main {

    public static void main(String[] args) {
        int value = 1;
	/*if(value == 1){
        System.out.println("Value was 1");
    }else if(value == 2){
        System.out.println("Value was 2");
    } else {
        System.out.println("Was not 1 or 2");
    }*/

        int switchValue = 1;

        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;

            case 3:
            case 4:
            case 5:
                System.out.println("was a 3, 4, or 5");
                System.out.println("It was actually " + switchValue);

            default:
                System.out.println("Was not 1 or 2");
                break;
        }


        char challengeL62 = 'A';
        switch (challengeL62) {
            case 'A':
                System.out.println("A was found");
                break;

            case 'B':
                System.out.println("B was found");
                break;

            case 'C':
            case 'D':
            case 'E':
                System.out.println(challengeL62 + " was found");

            default:
                System.out.println("Could not find A, B, C, D, or E");
                break;
        }

        String month = "January";
        switch (month.toLowerCase()){
            case "January":
                System.out.println("Jan");
                break;
            case "June":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
        }
    }
}
