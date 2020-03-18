package com.company;

public class Node extends ListItem {

    Node(Object value) {
        super(value);
    }

    @Override
    int compareTo(ListItem listItem) {
        if (listItem != null){
            return ((String) super.getValue()).compareTo((String) listItem.getValue());
        } else {
            return -1;
        }
    }

    @Override
    ListItem nextObject() {
        return this.right;
    }

    @Override
    ListItem previousObject() {
        return this.left;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.right = item;
        return this.right;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.left = item;
        return this.left;
    }
}
