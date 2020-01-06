package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Listing transactions - do that.  Then do videos

        Bank myBank = new Bank("Keshavarz Bank");

        myBank.addBranches("Shiraz");
        myBank.addBranches("Tehran");

        myBank.addCustomer("Amir", "Shiraz", 55.50);
        myBank.addCustomer("Golnaz", "Shiraz", 65.0);
        myBank.addCustomer("Mo", "Shiraz", 77);
        myBank.addCustomer("Ali","Tehran", 1110);
        myBank.addCustomer("Azadeh", "Tehran", 777);
        myBank.addCustomer("Reza", "Tehran", 986);

        myBank.addTransaction("Amir", "Shiraz", 6523);
        myBank.addTransaction("Amir", "Shiraz", 623);
        myBank.addTransaction("Golnaz", "Shiraz", 55896);

        myBank.showCustomers("Shiraz");
        System.out.println("---");
        myBank.showCustomerTransactions("Shiraz", "Amir");
        myBank.showCustomers("Tehran");

    }
}
