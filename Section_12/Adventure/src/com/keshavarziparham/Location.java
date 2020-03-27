package com.keshavarziparham;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;


    public Location(int locationID, String location) {
        this.locationID = locationID;
        this.description = location;
        this.exits = new HashMap<String, Integer>();
        this.exits.put("Q", 0);
        this.exits.put("QUIT", 0);
    }

    public void addExit(String direction, int location){
        this.exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, Integer> getExits() {
        //return a copy to the outside classes/objects (defensive programming)
        //This returns mutable objects
        return new HashMap<String, Integer>(this.exits);
    }
}
