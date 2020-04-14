package com.timbuchalka;


import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    /*Main method throws exception, since it is checked exception
    Caller the must either catch the exception or also specify
    that it will throw it.*/
    public static void main(String[] args) throws IOException {
        //Try with resources example
        //Automatically closes when using try with resources
        try(DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream("locations.dat")))){

            for(Location location : locations.values()){
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationID() + " : "
                + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);

                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q"));
                    System.out.println("\t\t" +  direction + ", " + location.getExits().get(direction));
                    locFile.writeUTF(direction);
                    locFile.writeInt(location.getExits().get(direction));
                }
            }
        }
        //Uses try with resources
//        //This block of code is similar to the commented code at the end of main method.
//        //Exception is suppressed and exception in try block is thrown up the call
//        //stack compared to try block.
//        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    //Ignores quit - makes it easier for editing text file
//                    if(!direction.equalsIgnoreCase("Q")) {
//                        //Writes directions to exits to directions.txt
//                        dirFile.write(location.getLocationID() + ", " + direction + ", " +
//                                location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        }

        //Doesn't use try with resources
//        FileWriter locFile = null;
//        try {
//            //File Writer object
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + ", " + location.getDescription()
//                        + "\n");
//                //Test
//                //throw new IOException("test exception thrown while writing");
//            }
//            //If there is an error within the for loop, it will leave the file open
//
//        } finally {
//            /*If Exception, it will thrown up the call stack back to the
//            main method*/
//            System.out.println("In finally block");
//            if (locFile != null) {
//                System.out.println("Attempting to close locFile");
//                locFile.close();
//            }
//        }
    }

    //This is so everything is created once
    static {
        //Can do without BufferedReader, but it would only scan in one character at a time
        try(Scanner scanner = new Scanner(new BufferedReader(
                new FileReader("locations_big.txt")))) {
            //Information is separated by the argument passed
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
                //Scan first ints (ints are first) and store it into loc
                int loc = scanner.nextInt();
                //Scanner will skip over delimiter (then are delimiter)
                scanner.skip(scanner.delimiter());
                //Then it will scan for string (then are strings)
                String description = scanner.nextLine();
                //Print out
                System.out.println("Imported loc: " + loc + ": " + description);
                //Store info from text
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Now read the exits 
        try (BufferedReader dirFile =
                new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while((input = dirFile.readLine()) != null){
                //Instead of block of code below, can parse with splits into an array
//                int loc = scanner.nextInt();
//                String direction = scanner.nextLine();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);
                String data[] = input.split(",");

                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        //Before we started writing to a file
        /*Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0,
                "You are sitting in front of a computer learning Java",null));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1,
                "You are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3,
                "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4,
                "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));*/
    }
    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
