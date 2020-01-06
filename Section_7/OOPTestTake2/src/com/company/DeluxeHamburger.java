package com.company;

public class DeluxeHamburger extends Hamburger {
    private String drinks = "Drinks";
    private String chips = "Chips";

    public DeluxeHamburger() {
        super("Deluxe Hamburger", "Deluxe Bread", "Deluxe meat", 7.00);
    }

    public void showExtras(){
        System.out.println("This comes with " + chips + " and " + drinks);
    }

    @Override
    public void enterToppings1(String topping1, double toppingPrice1) {
        System.out.println("Can't add more additions");
    }

    @Override
    public void enterToppings2(String topping2, double toppingPrice2) {
        System.out.println("Can't add more additions");
    }

    @Override
    public void enterToppings3(String topping3, double toppingPrice3) {
        System.out.println("Can't add more additions");
    }

    @Override
    public void enterToppings4(String topping4, double toppingPrice4) {
        System.out.println("Can't add more additions");
    }
}
