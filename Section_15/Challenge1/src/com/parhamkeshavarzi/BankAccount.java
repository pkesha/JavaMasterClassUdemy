package com.parhamkeshavarzi;

public class BankAccount {
    private double funds;

    public BankAccount(double funds) {
        this.funds = funds;
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
    public void addFunds(double add){
        synchronized (this){
            this.funds += add;
        }
    }

    public void removeFunds(double remove){
        synchronized (this){
            this.funds -= remove;
        }
    }

    public double getFunds() {
        return this.funds;
    }
}
