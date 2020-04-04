package com.keshavarziparham;

//import com.sun.source.tree.BreakTree;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup",0.5, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.5, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.4, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s : stockList.Items().keySet()){
            System.out.println(s);
        }

        Basket parhamsBasket = new Basket("Parham");
        sellItem(parhamsBasket, "car", 1);
        System.out.println(parhamsBasket);

        sellItem(parhamsBasket, "car", 1);
        System.out.println(parhamsBasket);

        sellItem(parhamsBasket, "car", 1);

        if(sellItem(parhamsBasket, "car", 1) != 1){
            System.out.println("There are no more cars in stock");
        }

        sellItem(parhamsBasket, "spanner", 5);
        //System.out.println(parhamsBasket);

        sellItem(parhamsBasket, "juice", 4);
        sellItem(parhamsBasket, "cup", 12);
        sellItem(parhamsBasket, "bread",1);
        //System.out.println(parhamsBasket);

        //System.out.println(stockList);

        Basket basket = new Basket("Customer");
        sellItem(basket,"cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        sellItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(parhamsBasket, "car", 1);
        removeItem(parhamsBasket, "cup", 9);
        removeItem(parhamsBasket, "car", 1);
        System.out.println("cars removed: " + removeItem(parhamsBasket,
                "car", 1)); //should not remove any

        System.out.println(parhamsBasket);

        removeItem(parhamsBasket, "bread", 1);
        removeItem(parhamsBasket, "cup", 3);
        removeItem(parhamsBasket, "juice", 4);
        removeItem(parhamsBasket, "cup", 3);
        System.out.println(parhamsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(stockList);

        //Can't item because of 'unmodifiable map' - will be added with other methods defined
//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);

        //Map might be unmodifiable, but can adjust individual items
        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);

//        for(Map.Entry<String, Double> price : stockList.PriceList().entrySet()){
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        checkOut(parhamsBasket);
        System.out.println(parhamsBasket);
    }


    public static int removeItem(Basket basket, String item, int quantity){
        //Retrieve item form stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static int sellItem(Basket basket, String item, int quantity){
        //Retrieve item form stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(stockList.reserveStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
