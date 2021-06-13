package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:music.db";

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artists";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    private Connection conn;


    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to a database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try{
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public List<Artist> queryArtists() {
//        Statement statement = null;
//        ResultSet resultSet = null;

        //By putting init statements as args in try block, no need for finally block
        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS)) {
//            statement = conn.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM" + TABLE_ARTISTS);

            List<Artist> artists = new ArrayList<>();

            // Store record artists records from database into List
            while(resultSet.next()){
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(COLUMN_ARTISTS_ID));
                artist.setName(resultSet.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
//        } finally {
//
//            //Close resultSet
//            try {
//                if(resultSet != null){
//                    resultSet.close();
//                }
//            } catch (SQLException e){
//                System.out.println("Error closing ResultSet: " + e.getMessage());
//            }
//
//            //Close statement
//            try {
//                if(statement != null) {
//                    statement.close();
//                }
//            } catch (SQLException e){
//                System.out.println("Error closing statement: " + e.getMessage());
//            }
//        }
    }
}
