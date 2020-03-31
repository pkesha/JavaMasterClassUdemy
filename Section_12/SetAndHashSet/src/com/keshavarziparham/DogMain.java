package com.keshavarziparham;

public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        //Labrador is an instance of Dog, so it will be true
        System.out.println(rover2.equals(rover));
        //Dog is not an instance of Labrador, so it will be false
        //Overriding method equals was commented in labrador, so now it's true
        System.out.println(rover.equals(rover2));
    }
}
