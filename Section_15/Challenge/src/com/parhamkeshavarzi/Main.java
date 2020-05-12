package com.parhamkeshavarzi;

public class Main {

    public static void main(String[] args) {
        final BankAccount jointBank = new BankAccount(1000, "22546");

        //Anonymous Threads
//        Thread trThread1 = new Thread(){
//            public void run() {
//                jointBank.addFunds(300.00);
//                jointBank.removeFunds(50.00);
//            }
//        };
//
//        Thread trThread2 = new Thread(){
//            public void run(){
//                jointBank.addFunds(203.75);
//                jointBank.addFunds(100.00);
//            }
//        };


        //Implement runnable


        Thread trThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                jointBank.addFunds(300.00);
                jointBank.removeFunds(50.00);
            }
        });

        Thread trThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                jointBank.addFunds(203.75);
                jointBank.addFunds(100.00);
            }
        });

        //Start Threads
        trThread1.start();
        trThread2.start();

        System.out.println("Total funds: " + jointBank.getFunds());
    }
}
