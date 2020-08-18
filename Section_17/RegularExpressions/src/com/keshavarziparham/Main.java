package com.keshavarziparham;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeee12Ghiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        //Result would be wild card for any character
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeef12GhhabcDeeeiiiijkl992";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello")); //False
        //Matches the whole String, not just part of it
        System.out.println(alphanumeric.matches("^abcDeee"));   //False
        System.out.println(alphanumeric.matches("^abcDeee12Ghiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("jkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][F]", "X"));

        System.out.println("Harry".replaceAll("[hH]arry", "Harry"));

        String newAlphanumeric = "abcDeee12Ghiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));

        //Next two lines yield the same result
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]", "X"));    //'-' specifies range
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        //Next two lines yield the same result
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        //Replaces all non-digits "\\D

        //Removes spaces, tabs, and new line
        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        //replaces new tab with X
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        // \\S will specify all non-whitespace characters

        //Replaces everything but white space, \\W will have the opposite effect
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));

        //Replaces with the start and the end of each word
        //Useful to replace and add tags around a word
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));

    }
}
