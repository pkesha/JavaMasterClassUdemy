package com.company;

public class Main {

    public static void main(String[] args) {
        VipCustomer Parham = new VipCustomer();
        System.out.println(Parham.getName());

        VipCustomer Pedrom = new VipCustomer("Pedrom", 5000.0);
        System.out.println(Pedrom.getName());

        VipCustomer Tim  = new VipCustomer("Tim", 5000.0,
                "tim@email.com");
        System.out.println(Tim.getName());

    }
}
