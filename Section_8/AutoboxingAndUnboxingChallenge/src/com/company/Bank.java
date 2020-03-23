package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branches> branches;

    public String getName() {
        return name;
    }

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranches(String branchesName){
        if(findBranches(branchesName) == null){
            this.branches.add(new Branches(branchesName));
            System.out.println("True for: " + branchesName);
            return true;
        } else {
            return false;
        }
    }

    private Branches findBranches(String branchesName){
        for (int i = 0; i < this.branches.size(); i++){
            Branches existingBranches = this.branches.get(i);
            if(existingBranches.getName().equals(branchesName)) {
                return existingBranches;
            }
        }
        return null;
    }

    //Adding a customer with initial transaction
    //Will check if branch and customer exists
    public boolean addCustomer(String nameCustomer, String nameBranch, double initialAmount){
        Branches existingBranches = findBranches(nameBranch);
        return ((findBranches(nameBranch)) != null &&
                (existingBranches.newCustomer(nameCustomer, initialAmount) == true)) ?
                true : false;
    }

    //Adding transaction
    //Checking if the branch or customer exists
    public boolean addTransaction(String nameCustomer, String nameBranch, double amount){
        Branches existingBranches = findBranches(nameBranch);
        return (((findBranches(nameBranch)) != null) &&
                (existingBranches.addCustomerTransaction(nameCustomer, amount) == true)) ?
                true : false;
    }

    //Show a list of customers
    public boolean showCustomers(String branch){
        Branches existingBranches = findBranches(branch);
        if(existingBranches != null){
            existingBranches.listCustomers();
            return true;
        } else {
            System.out.println("Branch " + branch + " does not exist.");
            return false;
        }
    }

    public boolean showCustomerTransactions(String branch, String customerName){
        Branches existingBranch = findBranches(branch);
        if((existingBranch == null)) {
            System.out.println("Branch does not exist");
            return false;
        } else if (existingBranch.listCustomerTransactions(customerName)){
            return true;
        } else{
            return false;
        }
    }

    /*
    For finding customer transactions and branch names:
    Could have gotten getters for branches and customers
    Assign the array list from the getters in the Bank class
    then for loop (in bank class) through the array lists retrieved from the other classes
     */
}
