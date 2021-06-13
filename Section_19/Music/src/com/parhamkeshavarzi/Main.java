package com.parhamkeshavarzi;

import model.DataSource;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if(!dataSource.open()) {
            System.out.println("Can't open database");
            return;
        }

        dataSource.close();
    }
}
