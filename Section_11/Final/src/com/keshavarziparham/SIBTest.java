package com.keshavarziparham;

public class SIBTest {

    public static final String owner;

    static {
        owner = "Parham";
        System.out.println("SIB static initialization block called");
    }

    public SIBTest() {
        System.out.println("SIB Constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod(){
        System.out.println("someMethod called");
    }
}
