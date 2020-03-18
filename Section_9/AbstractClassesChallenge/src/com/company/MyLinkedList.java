package com.company;

import jdk.swing.interop.SwingInterOpUtils;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        //If there is no root, set newItem as root
        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparision = currentItem.compareTo(newItem);
            if (comparision < 0) {
                //move right if newItem is greater
                if (currentItem.nextObject() != null) {
                    currentItem = currentItem.nextObject();
                    //There is no return statement here, it will loop until this
                    //Condition is no longer true
                } else {
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparision > 0) {
                //if less, insert before current
                if (currentItem.previousObject() != null) {
                    currentItem.previousObject().setNext(newItem);
                    newItem.setPrevious(currentItem.previousObject());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    //If null, then we reached root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present, no addition");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if (listItem == null) {
            System.out.println("Item is null, empty");
            return false;
        }
        ListItem current = this.root;
        int count = 0;

        while (current != null) {
            int compare = current.compareTo(listItem);
            //count++;
            System.out.println("Compare: " + compare);
            if (compare == 0) {
                current.nextObject().setPrevious(current.previousObject());
                current.previousObject().setNext(current.nextObject());
                System.out.println("Object: " + listItem.getValue() + " was removed");
                return true;
            } else if (compare < 0){
                current = current.nextObject();
            } else {
                break;
            }
        }
        System.out.println("Item " + listItem.getValue() + " was not found");
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.println("The list is empty");
        }else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.nextObject();
            }
        }
    }
}
