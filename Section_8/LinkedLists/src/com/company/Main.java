package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        com.company.Customer customer = new com.company.Customer("Tim", 54.96);
        com.company.Customer anotherCustomer;
        //Points to the same memory address of customer
        anotherCustomer = customer;
        //It will replace 54.96 with 12.18
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName()
                + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for(int i = 0; i < intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }

        //Adding element 2 to position 1 in the linked list
        intList.add(1, 2);

        for (int i = 0; i < intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }



    }
}
