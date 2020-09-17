package com.keshavarziparham;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String challenge1 = "I want a Bike.";
        System.out.println(challenge1.matches("I want a Bike."));

        // the '\\w' will match and character a - z, 0 - 9, and _
        // plus is a quantifier, will match one or more characters before period
        String regExp = "I want a \\w+.";
        System.out.println(challenge1.matches(regExp));
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches(regExp));

        String regExp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp));

        String regExp3 = "I want a \\w+.";
        //Turning regular expression into pattern
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscores";
        System.out.println(challenge4.replace(" ", "_"));

        String challenge5 = "aaabccccccdddefffg";
        String regExp5 = "[a-g]+";
        Pattern pattern1 = Pattern.compile(regExp5);
        Matcher matcher1 = pattern1.matcher(challenge5);
        System.out.println(matcher1.matches());

        //Using quantifiers to spell out exactly string "challenge5"
        //'^' and '$' match in it's entirety, not just part of the string
        System.out.println(challenge5.matches("^a{3}bc{6}d{3}ef{3}g$"));

        String challenge7 = "abcd.135";

        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));

        String challenge8 = "abc.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        while(matcher8.find()){
            System.out.println("Occurrences: " + matcher8.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);
        while(matcher8.find()){
            System.out.println("Occurrences " + matcher8.group(1));
        }

        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern10 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher10 = pattern10.matcher(challenge9);
        while(matcher10.find()){
            System.out.println("Occurrence: start = " + matcher10.start() + " end = " +
                    (matcher10.end(1) -1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);
        while(matcher11.find()){
            System.out.println("Occurrences: " + matcher11.group(1));
        }

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        //Group the last 4 digits to make it an or statement.  zero to 4 acceptable occurrences"
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})$"));
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})$"));
    }
}
