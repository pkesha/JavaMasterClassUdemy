package com.company;

public class Cuboid extends Rectangle {
    private double height;

    public double getHeight() {
        return height;
    }

    public double getVolume(){
        return this.height * getArea();
    }

    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = (height >= 0) ? height : 0;
    }
}
