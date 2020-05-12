package com.parhamkeshavarzi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double funds;
    private String accountNumber;
    private Lock lock;

    public BankAccount(double funds, String accountNumber) {
        this.funds = funds;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    //Synchronize places where fields are updated to avoid interference

    //Synchronize methods
//    public synchronized void addFunds(double add){
//        this.funds += add;
//    }
//
//    public synchronized void removeFunds(double remove){
//        this.funds -= remove;
//    }

    //Synchronize block - use 'this' and put code that will change fields within block
    //It's better to synchronize the smallest amount of code possible
//    public void addFunds(double add){
//        synchronized (this){
//            this.funds += add;
//        }
//    }
//
//    public void removeFunds(double remove){
//        synchronized (this){
//            this.funds -= remove;
//        }
//    }

    //Can be thread safe with Reentrant locks as well (instead of synchronize)
//    public void addFunds(double add){
//        lock.lock();
//        try{
//            this.funds += add;
//        }finally {
//            lock.unlock();
//        }
//    }
//
//
//    public void removeFunds(double remove){
//        lock.lock();
//        try{
//            this.funds -= remove;
//        }finally {
//            lock.unlock();
//        }
//    }

    public void addFunds(double add){
        //Since the bool variable is a local variable, it is thread safe
        //Local variables are stored on the thread stack
        boolean status = false;

        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    this.funds += add;
                    status = true;
                } finally {
                    lock.unlock();
                }
            }else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Transaction status = " + status);
    }

    public void removeFunds(double remove){
        boolean status = false;

        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    this.funds += remove;
                } finally {
                    lock.unlock();
                }
            }else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Transaction status = " + status);
    }

    public double getFunds() {
        return this.funds;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number = " + accountNumber);
    }
}
