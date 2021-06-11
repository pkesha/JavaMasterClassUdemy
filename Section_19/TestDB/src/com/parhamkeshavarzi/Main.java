package com.parhamkeshavarzi;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/owner/Documents/Java-Masterclass-Udemy/Section_19/" +
            "TestDB/src/com/parhamkeshavarzi/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        //Closes connection
//        try(Connection conn = DriverManager
//                .getConnection("jdbc:sqlite:/Users/owner/Documents/Java-Masterclass-Udemy/Section_19/" +
//                        "TestDB/src/com/parhamkeshavarzi/testjava.db");
//            Statement statement = conn.createStatement();)

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            //Won't automatically set rows
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + "text, " +
                    COLUMN_PHONE + "integer, " +
                    COLUMN_EMAIL +  "text)");

            //Method to insert into database
            insertContact(statement, "Parham", 13245, "parham@email.com");
            //Example statement with static final variables - replaced with method above
//            statement.execute("INSERT INTO" + TABLE_CONTACTS +
//                    " (" + COLUMN_NAME + ", " +
//                    COLUMN_PHONE + ", " +
//                    COLUMN_EMAIL + ")" +
//                    "VALUES('Parham, 12345, 'parham@email.com')");

//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Cat', 4562, 'Cat@email.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Dog', 4562, 'Dog@email.com')");

            //Updates entry
//            statement.execute("UPDATE contacts SET phone=432143 WHERE name='Dog'");

            //Delete entry
//            statement.execute("DELETE FROM contacts WHERE name='Joe'");

//            statement.execute("SELECT * FROM contacts");
//            //get the last statement result as an object
//            ResultSet results = statement.getResultSet();

            //Equivalent to the two lines above
            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            //Iterate through the content of that object
            while(results.next()) {
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

    //
    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO" + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ")" +
                "VALUES('" + name + "', " + phone + ", '" + email +"')");
    }
}
