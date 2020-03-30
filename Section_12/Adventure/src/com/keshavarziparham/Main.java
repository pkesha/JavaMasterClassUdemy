package com.keshavarziparham;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        //Using object Location as values - make new Instance of Location in map
        locations.put(0, new Location(0,
                "You are sitting in front of a computer learning Java", tempExit));

        //Adding valid exits in location 1
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1,
                "You are standing at the end of a road before a small brick building", tempExit));

        //The quit direction is automatically added in the constructor
        //tempExit.put("Q", 0); tempExit.put("Quit", 0);

        //tempExit is being used to store exits into locations.
        // This is necessary to make the locations class immutable
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3,
                "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));

        //Making a new map to refer to the keys for another map
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q"); vocabulary.put("NORTH", "N"); vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W"); vocabulary.put("EAST", "E");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) break;

            //Gets a copy of map that shows exits
            Map<String, Integer> exits = locations.get(loc).getExits();

            //Displays available exits
            System.out.println("Available exits are ");
            for (String exit : exits.keySet()) {
                //Want to show only directions represented as chars, not both chars and strings
                if (exit.length() > 1) continue;
                else System.out.print(exit + ", ");    //Look into this
            }

            System.out.println();
            String direction = scanner.nextLine().toUpperCase();

            //Split string into an array, and search each string for keys in Vocabulary
            if (direction.length() > 1) {
                String[] splitString = direction.split(" ");
                for (String word : splitString) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) loc = exits.get(direction);
            else System.out.println("You cannot go in that direction");
//            String[] directionForE = direction.split("E");
//
//            String[] directionForWest = direction.split("WEST");
//            String[] directionForW = direction.split("W");
//
//            String[] directionForNorth = direction.split("NORTH");
//            String[] directionForN = direction.split("N");
//
//            String[] directionForSouth = direction.split("SOUTH");
//            String[] directionForS = direction.split("S");


            //Checks to see if the direction entered is valid in the soft copy exits
//            if(exits.containsKey(direction)) loc = exits.get(direction);
//            else System.out.println("You cannot go in that direction")

//        String[] road = "You are standing at the end of a road before a small brick building".split("");
//        for (String i : road){
//            System.out.println(i);
//        }
//
//        System.out.println("==================");
//
//        String[] building = "You are inside a building, a well house for a small spring".split(",");
//        for (String i : building){
//            System.out.println(i);
//        }
        }

        //My attempt at the challenge
/*    public static void directionAnalysis(String[] string, Map exits, int loc){
        String direction;
        for (String word : string){
            if(exits.containsKey(word)) {
                loc = (Integer)exits.get(string);
            } else System.out.println("You cannot go in that direction");
        }
    }*/
    }
}