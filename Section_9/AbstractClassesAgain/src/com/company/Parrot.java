package com.company;

public class Parrot extends Birb {
    public Parrot(String name){
        super(name);
    }

    //Eat and breathe don't need to be reimplemented again
    @Override
    public void fly() {
        System.out.println("Flitting from branch to branch");
    }
}
