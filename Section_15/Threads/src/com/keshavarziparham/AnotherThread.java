package com.keshavarziparham;

import static com.keshavarziparham.ThreadColor.ANSI_BLUE;
public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            //If another thread wakes up this thread
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            //Will immediately terminate the current thread
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
}
