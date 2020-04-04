package com.keshavarziparham;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock = 0; // can be initialized later
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0; //or here (but you wouldn't normally do both)
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantities() {
        return quantityInStock - reserved;
    }

    public void setPrice(double price) {
        if (price > 0.0){
            this.price = price;
        }
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int finalizeStock(int quantity){
        if(quantity <= reserved){
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int reservedStock(int quantity){
        if(quantity <= availableQuantities()){  //Method not field
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreservedStock(int quantity){
        if(quantity <= reserved){
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");

        if (obj == this){ return true; }

        if ((obj == null) || (obj != this.getClass())){ return false;}

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if(this == o) { return 0; }
        if (o != null) { return this.name.compareTo(o.getName()); }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " price: " + this.price + ". Reserved: " + this.reserved;
    }

    public void adjustStock (int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) { this.quantityInStock = newQuantity; }
    }
}
