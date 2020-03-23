package com.company;

public class Account {
    private double accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private double phoneNumber;

    public Account(){ //this is the default constructor.  Initializes everything
        this(8987987, 2.60 , "Default Name", "email", 999999999);
        System.out.println("Empty constructor called");
    }

    public Account(String customerName, String email, double phoneNumber) {
        this(99999, 100.55, customerName, email, phoneNumber);
    }

    public Account(double accountNumber, double balance, String customerName,
                   String email, double phoneNumber){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(double accountNumber){
        this.accountNumber = accountNumber;
    }

    public double getAccountNumber(){
        return this.accountNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPhoneNumber (double phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public double getPhoneNumber(){
        return this.phoneNumber;
    }

    public void addBalance(double addMoney){
        this.balance += addMoney;
        System.out.println("New Balance: $" + this.balance);
    }

    public void subtractBalance(double removeMoney){
        if((this.balance - removeMoney) > 0){
            this.balance -= removeMoney;
            System.out.println("New Balance: $" + this.balance);
        } else{
            System.out.println("Insufficient fund");
        }

    }

}
