package com.company;

public class Wall {
    private double width;
    private double height;

    public void setWidth(double width) {
        this.width = (width > 0) ? width : 0;
    }

    public void setHeight(double height) {
        this.height = (height > 0) ? height : 0;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Wall(double width, double height) {
        this.width = width;
        this.width = (width > 0) ? width : 0;
        this.height = height;
        this.height = (height > 0) ? height : 0;
        getArea();
    }

    public Wall() {
        this(0.0, 0.0);
    }

    public double getArea(){
        return this.height * this.width;
    }
}
