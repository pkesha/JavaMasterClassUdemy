package com.timbuchalka;

import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
//        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//            for (Location location : locations.values()) {
//                locFile.writeInt(location.getLocationID());
//                locFile.writeUTF(location.getDescription());
//                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
//                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
//                locFile.writeInt(location.getExits().size() - 1);
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }
        //Writing values (I think)
        //'rwd' means that we want to open the file for read/write and that writes occur synchronously
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd"))
        {
            rao.writeInt(locations.size());
            //Calculating size
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationStart);

            long indexStart = rao.getFilePointer();

            int startPointer = locationStart;
            rao.seek(startPointer);

            for(Location location : locations.values()){
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        //direction, locationID, direction, locationID
                        //or like this -> N,1,U,2
                    }
                }
                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int)
                        rao.getFilePointer() - startPointer);
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();

                rao.seek(indexStart);
                for(Integer locationID : index.keySet()){
                    rao.writeInt(locationID);
                    rao.writeInt(index.get(locationID).getStartByte());
                    rao.writeInt(index.get(locationID).getLength());
                }
            }
        }
    }

    //1. First four bytes will contain the # of locations(bytes 0 - 3)
    //2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    //3. The next section of the file will contain the index (the index is 1692 bytes long.
    //   It will start at 8 and end at byte 1699
    //4. The final section of the file will contain the location records (the data).
    //   It will start at byte 1700

    //I think the static block is where we read in, values
    static {
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            int locationStart = ra.readInt();

            while(ra.getFilePointer() < locationStart){
                int locationID = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationID, record);
            }
        } catch (IOException e) {
            System.out.println("IOException in static initializer " + e.getMessage());
        }

//        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    //This will read objects from .dat file, it should return 'Location' type objects
//                    //Have to cast it to avoid exceptions
//                    Location location = (Location) locFile.readObject();
//                    System.out.println("Read location " + location.getLocationID() + " : "
//                            + location.getDescription());
//                    System.out.println("Found" + location.getExits().size() + " exits");
//                    //Storing it into locations map object
//                    locations.put(location.getLocationID(), location);
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//        } catch (InvalidClassException e){
//            System.out.println("InvalidClassException " + e.getMessage());
//        }
//        catch (IOException io){
//            System.out.println("IO Exception: " + io.getMessage());
//        } catch(ClassNotFoundException e){
//            System.out.println("ClassNotFoundException " + e.getMessage());
//        }
//            while(!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locID = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    System.out.println("Read location " + locID + " : " + description);
//                    System.out.println("Found " + numExits + " exits");
//                    for(int i=0; i<numExits; i++) {
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("\t\t" + direction + "," + destination);
//                    }
//                    locations.put(locID, new Location(locID, description, exits));
//
//                } catch(EOFException e) {
//                    eof = true;
//                }
//
//            }
//        } catch(IOException io) {
//            System.out.println("IO Exception");

//        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        // Now read the exits
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public Location getLocation(int locationId) throws IOException{
        //Builds up description, exits, location object, adds exits and then returns that

        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        //Adding exits
        Location location = new Location(locationId, description, null);
        if(locationId != 0){
            for(int i = 0; i < exitPart.length; i++){
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1} = " + exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
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

    //Reason for throwing is allowing OS to bubble up
    public void close() throws IOException{
        ra.close();
    }
}
