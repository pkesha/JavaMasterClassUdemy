package com.parhamkeshavarzi;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        //Closes connection
//        try(Connection conn = DriverManager
//                .getConnection("jdbc:sqlite:/Users/owner/Documents/Java-Masterclass-Udemy/Section_19/" +
//                        "TestDB/src/com/parhamkeshavarzi/testjava.db");
//            Statement statement = conn.createStatement();)

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/owner/Documents/Java-Masterclass-Udemy/Section_19/" +
                    "TestDB/src/com/parhamkeshavarzi/testjava.db");
            //Won't automatically set rows
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " +
                    "contacts (name TEXT, phone INTEGER, email TEXT)");

//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Cat', 4562, 'Cat@email.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Dog', 4562, 'Dog@email.com')");

            //Updates entry
//            statement.execute("UPDATE contacts SET phone=432143 WHERE name='Dog'");

            //Delete entry
//            statement.execute("DELETE FROM contacts WHERE name='Joe'");

            statement.execute("SELECT * FROM contacts");
            //get the last statement result as an object
            ResultSet results = statement.getResultSet();

            //Iterate through the content of that object
            while(results.next()){
                //This will display the results entry
                System.out.println(
                        //Get the column labels based off the name
                        results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }

            results.close();

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
