package com.company;

public class Floor {
    private double width;
    private double length;

    public Floor(double width, double length) {
        this.width = (width > 0) ? width : 0;
        this.length = (length > 0) ? length : 0;
    }

    public double getArea(){
        return this.width * this.length;
    }
}
