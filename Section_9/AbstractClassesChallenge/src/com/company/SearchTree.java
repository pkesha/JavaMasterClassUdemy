package com.company;

import java.util.List;

public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root){
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;

        //current item will never be null.  If there is a null value, the item will
        //be inserted before current item ever becomes null, therefore breaking the while
        //loop anyways.  Could have written while(true){}
        while(currentItem != null) {
            int compare = (currentItem.compareTo(item));
            if (compare < 0) {
                if (currentItem.nextObject() != null) {
                    //new item is greater, move right
                    currentItem = currentItem.nextObject();
                } else {
                    //There's no node to the right so add the element
                    currentItem.setNext(item);
                    return true;
                }
            } else if (compare > 0) {
                //new item is less, move left
                if (currentItem.previousObject() != null){
                    currentItem = currentItem.previousObject();
                } else {
                    //no node to left, add
                    currentItem.setPrevious(item);
                    return true;
                }
            } else {
                //equal so don't add
                System.out.println(item.getValue() + " is already present");
                return false;
            }
        }
        //Can't ever reach this, but java will not compile if there's no return
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        //Mostly traversing the tree
        while (currentItem != null){
            int compare = currentItem.compareTo(item);
            if (compare < 0){
                parentItem = currentItem;
                currentItem = currentItem.nextObject();
            } else if (compare > 0){
                parentItem = currentItem;
                currentItem = currentItem.previousObject();
            } else {
                treeRemove(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void treeRemove(ListItem item, ListItem parent){
        if(item.nextObject() == null){
            //no right tree, so make parent to point to left (which may be null)
            if(parent.previousObject() == item){
                //item is right child of it's parent
                parent.setNext(item.previousObject());
            } else if (parent.previousObject() == item){
                //item is left child of its parent
                parent.setPrevious(item.previousObject());
            } else {
                //parent must be item, which means were looking at the root of the tree
                this.root = item.previousObject();
            }
        } else if (item.previousObject() == null){
            //no left tree, so make parent point to right tree (which may be null)
            if (parent.nextObject() == item){
                //item is right child of its parent
                parent.setNext(item.nextObject());
            } else if (parent.previousObject() == item){
                //item is left child of its parent
                parent.setPrevious(item.nextObject());
            } else {
                //parent must be item which mean we were looking at the root of the tree
                this.root = item.nextObject();
            }
        } else{
            //neither left nor right are null so deletion is a lot trickier
            //From the right sub-tree, find the left most value
            ListItem current = item.nextObject();
            ListItem leftMostParent = item;
            while(current.previousObject() != null){
                leftMostParent = current;
                current = current.previousObject();
            }
            //Now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            //and delete the smallest
            if (leftMostParent == item){
                //there was no leftmost, so current points to smallest (leftmost)
                //It will now be deleted
                item.setValue(current.nextObject());
            } else {
                //set the smallest node's parent to point to the
                //smallest node's right child (which may be null)
                leftMostParent.setPrevious(current.nextObject());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        //recursive method
        if (root != null){
            traverse(root.previousObject());
            System.out.println(root.getValue());
            traverse(root.nextObject());
        }
    }
}
