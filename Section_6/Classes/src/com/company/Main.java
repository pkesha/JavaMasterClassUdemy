package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        Car holden = new Car();

        //Call the method
        porsche.setModel("Carrera");
        System.out.println("Model is " + porsche.getModel());
    }
}
