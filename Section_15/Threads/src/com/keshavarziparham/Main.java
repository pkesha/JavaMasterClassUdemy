package com.keshavarziparham;

import static com.keshavarziparham.ThreadColor.ANSI_PURPLE;
import static com.keshavarziparham.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        //Have to create an instance and then start another thread
        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        //Anonymous thread
        new Thread(){
            public void run(){
                System.out.println(ANSI_RED + "Hello from the anonymous class thread");
            }
        }.start();

        //Uses color from previous thread - Not anymore, ANSI_PURPLE was added
        //The console might print this in a different order
        System.out.println(ANSI_PURPLE + "Hello again from the main thread");

        //Can't reuse the instance.  Runs only once
        //anotherThread.start();
    }
}
