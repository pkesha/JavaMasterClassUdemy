package com.company;

//

public class Main {

    public static void main(String[] args) {
        //MyLinkedList list = new MyLinkedList(null);
        SearchTree tree = new SearchTree(null);
        String stringData = "5 9 0 2 8 5 0 1";

        String[] data = stringData.split(" ");
        for (String s : data){
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());
        /*list.traverse(list.getRoot());

        list.removeItem(new Node("4"));
        list.removeItem(new Node ("5"));

        System.out.println();
        list.traverse(list.getRoot());*/

    }
}
