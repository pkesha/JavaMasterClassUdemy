package com.company;

public class Main {

    public static void main(String[] args) {
        Account bobsAccount = new Account(1234, 0.00, "Bob Brown",
        "myemail@bob.com", 344324);

        bobsAccount.subtractBalance(100.0);
        System.out.println(bobsAccount.getAccountNumber());
        System.out.println(bobsAccount.getBalance());

        bobsAccount.addBalance(50.0);
        bobsAccount.subtractBalance(100.0);

        bobsAccount.addBalance(51.0);
        bobsAccount.subtractBalance(100.0);

        Account timsAccount = new Account("Tim", "tim@gmail.com", 12345);
        System.out.println(timsAccount.getAccountNumber() + " name " + timsAccount.getCustomerName());
    }
}
