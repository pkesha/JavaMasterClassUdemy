package com.company;

public class HealthyBurger extends Hamburger {
    private String topping5;
    private double toppingPrice5;

    private String topping6;
    private double toppingPrice6;

    public HealthyBurger(String meat) {
        super("Healthy Burger", "Brown Rye", meat, 5.0);
    }

    public void enterToppings5(String topping5, double toppingPrice5){
        this.topping5 = topping5;
        this.toppingPrice5 = toppingPrice5;
        System.out.println("Topping 5 added: " + topping5 + " which costs $" +
                toppingPrice5);
    }

    public void enterToppings6(String topping6, double toppingPrice6){
        this.topping6 = topping6;
        this.toppingPrice6 = toppingPrice6;
        System.out.println("Topping 6 added: " + topping6 + " which costs $" +
                toppingPrice6);
    }

    @Override
    public double totalPrice() {
        double totalPrice = super.totalPrice();
        if(topping5 != null){
            totalPrice += toppingPrice5;
        }
        if(topping6 != null){
            totalPrice += toppingPrice6;
        }
        return totalPrice;
    }
}
