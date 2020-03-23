package com.company;

public class LivingRoom {
    private Table coffeeTable;
    private Chair recliner;
    private Chair regular;
    private int entranceOrExits;
    private boolean TV;

    public LivingRoom(Table coffeeTable, Chair recliner, Chair regular, int entranceOrExits, boolean TV) {
        this.coffeeTable = coffeeTable;
        this.recliner = recliner;
        this.regular = regular;
        this.entranceOrExits = entranceOrExits;
        this.TV = TV;
    }

    public Table getCoffeeTable() {
        return coffeeTable;
    }

    public Chair getRecliner() {
        System.out.println("This chair can recline");
        relaxation();
        return recliner;
    }

    public Chair getRegular() {
        return regular;
    }

    public int getEntranceOrExits() {
        return entranceOrExits;
    }

    public boolean isTV() {
        return TV;
    }

    private void relaxation(){
        System.out.println("I am relaxed at the living room");
    }
}
