package com.parhamkeshavarzi;

public class SharedResource {
    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    //When changing data, making it
    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
