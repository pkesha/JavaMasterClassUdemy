package com.company;

public class Main {


    public static void main(String[] args) {
        regularHamburger();
        healthyHamburger();
        deluxeHamburger();
    }

    public static void regularHamburger(){
        Hamburger basicBurger = new Hamburger("Beef Burger", "White",
                "Beef", 3.50);
        System.out.println("Original Hamburger price: $" + basicBurger.getPrice());

        basicBurger.enterToppings1("Cheese", 0.50);
        basicBurger.enterToppings2("Pineapple", 1.00);

        System.out.println("Total price of " + basicBurger.getName() +
                " is: " + "$" + basicBurger.totalPrice());
    }

    public static void healthyHamburger(){
        Hamburger healthyBurgerFood = new HealthyBurger("Lean Beef Burger");
        System.out.println("Original price: $" + healthyBurgerFood.getPrice());

        healthyBurgerFood.enterToppings1("Cheese", 0.50);
        healthyBurgerFood.enterToppings2("Pineapple", 1.00);


        System.out.println("Total price of " + healthyBurgerFood.getName() +
                " is: " + "$" + healthyBurgerFood.totalPrice());
    }

    public static void deluxeHamburger(){
        DeluxeHamburger myDeluxeBurger = new DeluxeHamburger();
        System.out.println("Original price: $" + myDeluxeBurger.getPrice());
        myDeluxeBurger.showExtras();
        System.out.println("Total price of " + myDeluxeBurger.getName() +
                " is: " + "$" + myDeluxeBurger.totalPrice());
    }
}
