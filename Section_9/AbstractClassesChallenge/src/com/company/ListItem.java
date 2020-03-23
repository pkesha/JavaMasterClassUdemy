package com.company;

public abstract class ListItem {
    protected ListItem right;
    protected ListItem left;
    protected Object value;

    ListItem(Object value){
        this.value = value;
        this.right = null;
        this.left = null;
    }

    abstract int compareTo(ListItem listItem);

    //These were in the description
    abstract ListItem nextObject();
    abstract ListItem previousObject();
    abstract ListItem setNext(ListItem listItem);
    abstract ListItem setPrevious(ListItem listItem);

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
