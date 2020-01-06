package com.company;

public class Hamburger {
    private String name;
    private String roll;
    private String meat;
    private double price;

    private double toppingPrice1;
    private String topping1;

    private double toppingPrice2;
    private String topping2;

    private double toppingPrice3;
    private String topping3;

    private double toppingPrice4;
    private String topping4;

    public Hamburger(String name, String roll, String meat, double price) {
        this.name = name;
        this.roll = roll;
        this.meat = meat;
        this.price = price;
    }

    public void enterToppings1(String topping1, double toppingPrice1){
        this.topping1 = topping1;
        this.toppingPrice1 = toppingPrice1;
        System.out.println("Topping 1 added: " + topping1 + " which costs $" + toppingPrice1);
    }

    public void enterToppings2(String topping2, double toppingPrice2){
        this.topping2 = topping2;
        this.toppingPrice2 = toppingPrice2;
        System.out.println("Topping 2 added: " + topping2 + " which costs $" + toppingPrice2);
    }

    public void enterToppings3(String topping3, double toppingPrice3){
        this.topping3 = topping3;
        this.toppingPrice3 = toppingPrice3;
        System.out.println("Topping 3 added: " + topping3 + " which costs $" + toppingPrice3);
    }

    public void enterToppings4(String topping4, double toppingPrice4){
        this.topping4 = topping4;
        this.toppingPrice4 = toppingPrice4;
        System.out.println("Topping 4 added: " + topping4 + " which costs $" + toppingPrice4);
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getMeat() {
        return meat;
    }

    public double getPrice() {
        return price;
    }

    public double totalPrice(){
        double totalPrice = this.price;
        if (topping1 != null){
            totalPrice += toppingPrice1;
        }
        if (topping2 != null){
            totalPrice += toppingPrice2;
        }
        if (topping3 != null){
            totalPrice += toppingPrice3;
        }
        if (topping4 != null){
            totalPrice += toppingPrice4;
        }
        return totalPrice;
    }
}
