package com.keshavarziparham;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String thirdAlphaNumericString = "abcDeee12Ghiiiijkl99z";
        //The 3 in curly braces indicates 3 letters of e - quantifier
        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY"));
        //Only replaces any characters "abcDe" - do not care about the rest
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe", "YYY"));
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe*", "YYY"));
        //Will match and String where the first chars have 2 - 5 e's after it
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(thirdAlphaNumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading<h1>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        //Regular expression assigned to String
        //Dot will match every character and star means zero or more
        // - anything before or after will be a match
        String h2Pattern = "<h2>";
        //Pattern.CASE_INSENSITIVE - don't care about case
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        //Text want to check against
        Matcher matcher = pattern.matcher(htmlText);
        //Will match the String as a whole
        //Internal state of matcher will be updated and needs to be reset
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to "
                    + matcher.end());
        }

        //The parenthesis is used to group regular expressions.  Not apart of the pattern
        //The group represents h2 tags and anything between
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()){
            System.out.println("Occurrences: " + groupMatcher.group(1));
        }

        //2 groups - <h2> and </h2>
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()){
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        //If capital or lower case H, consider it a match
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));

        //[^abc] - not character when carrot is first character
        String tvTest = "tsTvtkt";
        //T not followed by v
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotMatcher.find()){
            count++;
            System.out.println("Occurrences: " + count + " : " + tNotMatcher.start() + " to " +
                    tNotMatcher.end());
        }
        //t{?=v} t followed by v but didn't want to include v in the match
    }
}
