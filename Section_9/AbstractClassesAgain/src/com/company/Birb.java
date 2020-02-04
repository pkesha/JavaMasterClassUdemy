package com.company;

public abstract class Birb extends Animal implements CanFly {
    public Birb(String name){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, Breathe out, repeat");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flapping it's wings");
    }
}
