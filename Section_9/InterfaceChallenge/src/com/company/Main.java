package com.company;

import javax.swing.*;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Data1 ash = new Data1("Ash", "Harvard",
                7, 7);

        /*Since it's initialized as an interface, the object needs to be casted to
        access the methods*/
        ISaveable abe = new Data2("Abe", "UIC", 22);
        System.out.println(((Data2) abe).toString());

        System.out.println(ash.toString());
        System.out.println(abe.toString());
        //Commented loadDate so it will save all objects initialized
        saveDate(ash);
        saveDate(abe);
        //loadDate(ash);
        //loadDate(abe);

        System.out.println(ash);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit){
            System.out.println("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;

                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    //Add object as a constructor, save it through the method
    public static void saveDate(ISaveable objectToSave){
        //method .write is defined by user. Returns list so we can get size
        for(int i = 0; i < objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) +
                    " to storage device");
        }
    }

    public static void loadDate(ISaveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }



}
