package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getDurationString( 20));
    }

    public static String getDurationString (long minutes, long seconds){
        String hoursLeading, minutesLeading, secondsLeading;

        if ((minutes < 0) || ((seconds < 0) || (seconds > 60))){
            return "Invalid values entered";
        } else {
            long hours = minutes / 60;
            long minutesReturn = minutes % 60;

            //If hours is less than 10, leading zero
            if (hours < 9){
                hoursLeading = "0" + hours;
            } else {
                //Can't cast to string for some reason but this works
                hoursLeading = "" + hours;
            }

            //Doing the same with minutes
            if (minutes < 9) {
                minutesLeading = "0" + minutesReturn;
            } else {
                minutesLeading = "" + minutesReturn;
            }

            //Now for seconds
            if (seconds < 9){
                secondsLeading = "0" + seconds;
            } else {
                secondsLeading = "" + seconds;
            }

            return hoursLeading + "h " + minutesLeading + "m " + secondsLeading + "s";
        }
    }

    public static String getDurationString (long seconds){
        if (seconds < 0){
            return "Invalid Value";
        } else {
            long secondsToMinutes = seconds /60;
            long secondsRemainder = seconds % 60;

            return getDurationString(secondsToMinutes, secondsRemainder);
        }
    }

}
