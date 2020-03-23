package com.company;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Branches {
    private String name;
    private ArrayList<Customer> customers;

    public String getName() {
        return name;
    }

    public Branches(String name){
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName) == null){
            this.customers.add(new Customer(initialAmount, customerName));
            System.out.println("Customer added: " + customerName);
            return true;
        } else{
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        } else{
            return false;
        }
    }

    private Customer findCustomer(String customerName){
        for (int i = 0; i < this.customers.size(); i++) {
            Customer checkCustomer = this.customers.get(i);
            if (checkCustomer.getName().equals(customerName)) {
                return checkCustomer;
            }
            /* else {
                return null
            }
            //The else statement will always gurantee to break the for loop
            //This will prevent from checking the entirety of the Array list
             */
        }
        return null;
    }

    public void listCustomers() {
            if (this.customers.size() > 0) {
                for (int i = 0; i < this.customers.size(); i++) {
                    System.out.println("Customer "+ i +" at branch " + this.name + ": "
                            + this.customers.get(i).getName());
                }
            } else{
                System.out.println("No names have been added to this branch");
            }
    }

    //Checks to see if the customer exists before listing transactions
    public boolean listCustomerTransactions(String customerName){
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null){
            existingCustomer.listTransactions();
            return true;
        }else{
            System.out.println("Customer does not exist");
            return false;
        }
    }
}
