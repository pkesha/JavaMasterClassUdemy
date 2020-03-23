package com.company;

public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore("Parham", 500);
        System.out.println("New is score " + newScore);

        //Overload makes a method versatile
        calculateScore(75);

        //This is testing for challenge
        System.out.println("Conversion challenge result: " +
                calcFeetAndInchesToCentimeters(1, 13) + " cm.");


    }

    //-----------Non-main methods
    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }

    public static void calculateScore() {
        System.out.println("No player, no score");
    }

    //------------------------Coding challenge Lecture 57
    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if ((feet < 0) || ((inches <= 0) || (inches >= 12))) {
            return -1;
        }else {
            return (((12 * 2.54) * feet) + (inches * 2.54));
        }
    }
    public static double calcFeetAndInchesToCentimeters(double inchesOnly){
        if(inchesOnly <= 0){
            return -1;
        } else {
            int feetSecond = (int)(inchesOnly/12d);
            int inchesRemainder = (int)(inchesOnly)%12;
            return calcFeetAndInchesToCentimeters(feetSecond, inchesRemainder);
        }
    }
}
