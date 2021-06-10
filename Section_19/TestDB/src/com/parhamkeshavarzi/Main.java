package com.parhamkeshavarzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try(Connection conn = DriverManager
                .getConnection("jdbc:sqlite:/Users/owner/Documents/Java-Masterclass-Udemy/Section_19/TestDB/src/com/parhamkeshavarzi/testjava.db");
            Statement statement = conn.createStatement();)
            {
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
            //Manual way w/o using try block parenthesis
            //Closes statement
            statement.close();

            //Closes connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
