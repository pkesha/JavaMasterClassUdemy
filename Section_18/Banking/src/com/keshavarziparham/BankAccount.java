package com.keshavarziparham;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    //Branch arguement is true if the customre is performing the transaction at a branch
    //It's false if the customer is performing the transaction at an ATM
    public double deposit(double amount, boolean branch){
        this.balance += amount;
        return this.balance;
    }
    //Branch arguement is true if the customre is performing the transaction at a branch
    //It's false if the customer is performing the transaction at an ATM
    public double withdraw(double amount, boolean branch){
        //Early vs of JUnit, need a to surround a try catch block when throwing exceptions
        if ((amount > 500) && !branch){
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        balance -= amount;
        return balance;
    }

    public double getBalance(){
        return balance;
    }

    public boolean isChecking() {
        return accountType == CHECKING;
    }

    //More methods that use firstName, lastName, and performs other functions
}
