package com.keshavarziparham;

import static com.keshavarziparham.ThreadColor.ANSI_PURPLE;
import static com.keshavarziparham.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        //Have to create an instance and then start another thread
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        //Common mistake example:
        //The right way to do start thread:
        anotherThread.start();
        //The wrong way to start thread (It's running from the main thread): anotherThread.run();

        //Anonymous thread
        new Thread(){
            public void run(){
                System.out.println(ANSI_RED + "Hello from the anonymous class thread");
            }
        }.start();

        //created Thread instance based on the MyRunnable class created
        //This is subclassing the thread class
        Thread myRunnableThread = new Thread(new MyRunnable())
        {//The anonymous class instance - use brackets for creating it after above line
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class' implementation of run()");
                try{
                    //Want 'myRunnableThread to .join() anotherThread, will wait 2 seconds
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out, so I'm running again");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I Couldn't wait after all.  I was interrupted");
                }
            }
        };
        myRunnableThread.start();
        //anotherThread.interrupt();

        //Uses color from previous thread - Not anymore, ANSI_PURPLE was added
        //The console might print this in a different order
        System.out.println(ANSI_PURPLE + "Hello again from the main thread");

        //Can't reuse the instance.  Runs only once
        //anotherThread.start();
    }
}
