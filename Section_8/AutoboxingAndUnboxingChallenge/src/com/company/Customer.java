package com.company;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transaction;
    private String name;

    public Customer(double initialTransaction, String name) {
        this.transaction = new ArrayList<Double>();
        this.name = name;
        addTransaction(initialTransaction);
    }
    public void addTransaction(double amount){
        this.transaction.add(amount);
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public String getName() {
        return name;
    }

    public void listTransactions(){
        if(this.transaction.size() > 0){
            System.out.println("Transactions:");
            for (int i = 0; i < this.transaction.size(); i++){
                System.out.println("$" + this.transaction.get(i));
            }
        } else {
            System.out.println("No transactions - Customer does exist");
        }
    }
}
