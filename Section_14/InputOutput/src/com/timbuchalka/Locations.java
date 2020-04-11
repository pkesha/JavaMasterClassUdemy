package com.timbuchalka;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    /*Main method throws exception, since it is checked exception
    Caller the must either catch the exception or also specify
    that it will throw it.*/
    public static void main(String[] args) throws IOException {

        //This block of code is similar to the commented code starting around line 28
        //Exception is suppressed and exception in try block is thrown up the call stack compared to try block
        try(FileWriter locFile = new FileWriter("locations.txt")){
            FileWriter dirFile = new FileWriter("directions.txt");
            for (Location location : locations.values()){
                locFile.write(location.getLocationID() + ", " +
                        location.getDescription() + "\n");
                
                for (String direction : location.getExits().keySet()){
                    //Writes directions to exits to directions.txt
                    dirFile.write(location.getLocationID() + ", " + direction +
                            location.getExits().get(direction) + "\n");
                }
            }
        }
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
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
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
        locations.put(5, new Location(5, "You are in the forest",tempExit));

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
