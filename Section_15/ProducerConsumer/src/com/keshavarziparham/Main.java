package com.keshavarziparham;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.keshavarziparham.Main.EOF;

public class Main {
    //Test
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        //There will be issues with threads since List class is unsynchronized
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        //ReentrantLock bufferlock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for the Callable class");
                return "This is the callable result";
            }
        });

        executorService.shutdown();
        /*
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
         */
    }
}

class MyProducer implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;
    //private ReentrantLock bufferLock;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color /*,ReentrantLock bufferlock*/) {
        this.buffer = buffer;
        this.color = color;
        //this.bufferLock = bufferlock;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num : nums){
            try {
                System.out.println(color + "Adding..." + num);
                //bufferLock.lock();
                buffer.put(num);
                //Commented L277 (ArrayBlockingQueue Class)
//                try {
//                    buffer.add(num);
//                } finally {
//                    bufferLock.unlock();
//                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        //bufferLock.lock();
        try{
            //buffer.add("EOF");
            buffer.put("EOF");
        } catch (InterruptedException e){

        }
    }
}

class MyConsumer implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;
    //private ReentrantLock bufferlock;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){

        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    /* Since List is unsynchronized, before remove method is run in one thread, another thread
                    may execute and incorrectly execute when an item was supposed to be removed */
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
