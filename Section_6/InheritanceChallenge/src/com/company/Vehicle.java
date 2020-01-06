package com.company;

public class Vehicle {
    private String name;
    private String size;

    private double currentVelocity;
    private double currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.currentDirection = 0;
        this.currentVelocity = 0;
    }

    public void steer(int direction){
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees.");
    }

    public void move(double velocity, double direction){
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at " + velocity +
                " in direction "  + currentDirection);
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getCurrentVelocity() {
        return currentVelocity;
    }

    public void stop(){
        this.currentVelocity = 0;
    }

    public double getCurrentDirection() {
        return currentDirection;
    }
}
