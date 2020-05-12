package com.parhamkeshavarzi;

public class BankAccount {
    private double funds;

    public BankAccount(double funds) {
        this.funds = funds;
    }

    public void addFunds(double add){
        this.funds += add;
    }

    public void removeFunds(double remove){
        this.funds -= remove;
    }

    public double getFunds() {
        return this.funds;
    }
}
