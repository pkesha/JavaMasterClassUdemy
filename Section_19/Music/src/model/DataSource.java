package model;

import javax.xml.transform.Result;
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
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SOND_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_ALBUM = 3;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " +TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = \"";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " +
                    TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";

    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
            "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " ORDER BY " +
            TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_INFO =  "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = \"";

    // Question is a place holder
    // SELECT name, album, track FROM artist_list WHERE title = ?
    // Replaced by an argument in method querySongInfoView
    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + '(' +
            COLUMN_ARTIST_NAME + ") VALUES(?)";

    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
            '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM +
            ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    private Connection conn;

    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);

            queryArtist = conn.prepareStatement(QUERY_ALBUM);
            queryAlbum = conn.prepareStatement(QUERY_ARTIST);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to a database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try{
            if(querySongInfoView != null) {
                querySongInfoView.close();
            }

            if(insertIntoSongs != null) {
                insertIntoSongs.close();
            }

            if(insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }

            if(insertIntoArtists != null) {
                insertIntoArtists.close();
            }

            if(queryArtist != null) {
                queryArtist.close();
            }

            if(queryAlbum != null) {
                queryAlbum.close();
            }

            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public List<Artist> queryArtists(int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if(sortOrder != ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                // Default behavior
                sb.append("ASC");
            }
        }
//        Statement statement = null;
//        ResultSet resultSet = null;

        //By putting init statements as args in try block, no need for finally block
        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString())) {
//            statement = conn.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM" + TABLE_ARTISTS);

            List<Artist> artists = new ArrayList<>();

            // Store record artists records from database into List
            while(resultSet.next()){
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_ID));
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

    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");

//        StringBuilder sb = new StringBuilder("SELECT ");
//        sb.append(TABLE_ALBUMS);
//        sb.append('.');
//        sb.append(COLUMN_ARTIST_NAME);
//        sb.append(" FROM ");
//        sb.append(TABLE_ALBUMS);
//        sb.append(" INNER JOIN ");
//        sb.append(TABLE_ARTISTS);
//        sb.append(" ON ");
//        sb.append(TABLE_ALBUMS);
//        sb.append('.');
//        sb.append(COLUMN_ALBUM_ARTIST);
//        sb.append(" = ");
//        sb.append(TABLE_ARTISTS);
//        sb.append('.');
//        sb.append(COLUMN_ARTIST_ID);
//        sb.append(" WHERE ");
//        sb.append('.');
//        sb.append(COLUMN_ARTIST_NAME);
//        sb.append(" = \"");
//        sb.append(artistName);
//        sb.append("\"");

        if(sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
//            sb.append(" ORDER BY ");
//            sb.append(TABLE_ALBUMS);
//            sb.append('.');
//            sb.append(COLUMN_ALBUM_NAME);
//            sb.append(" COLLATE NOCASE ");

            if(sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        System.out.println("SQL statement = " + sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {
            List<String> albums = new ArrayList<>();
            while(results.next()) {
                //Index of resultset column not, table
                albums.add(results.getString(1));
            }

            return albums;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder) {
        StringBuilder stringBuilder = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        stringBuilder.append(songName);
        stringBuilder.append("\"");

        if(sortOrder != ORDER_BY_NONE) {
            stringBuilder.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if(sortOrder == ORDER_BY_DESC) {
                stringBuilder.append("DESC");
            } else {
                stringBuilder.append("ASC");
            }
        }

        System.out.println("SQL statement: " + stringBuilder.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(stringBuilder.toString())) {
            List<SongArtist> songArtists = new ArrayList<>();

            while(results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

    }

    public void querySongsMetaData() {
        String sql = "SELECT * FROM " + TABLE_SONGS;
        try(Statement statement = conn.createStatement();
            // Get schema data
            ResultSet resultSet = statement.executeQuery(sql)){
            ResultSetMetaData meta = resultSet.getMetaData();
            int numColumns = meta.getColumnCount();
            for(int i = 1; i <=numColumns; i++) {
                System.out.format("Column %d in the songs table is names %s\n",
                        i, meta.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT(*) AS count, MIN(_id) as min_id FROM " + table;
        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            // Asking for one result, so it will be in column 1
//            int count = resultSet.getInt(1);

            int count = resultSet.getInt("count");
            int min = resultSet.getInt("min_id");
            return count;
        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            return -1;
        }
    }

    // Creates sql view
    public boolean createViewForSongArtists() {

        try(Statement statement = conn.createStatement()) {

            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;

        } catch(SQLException e) {
            System.out.println("Create View failed: " + e.getMessage());
            return false;
        }
    }

    public List<SongArtist> querySongInfoView(String title) {
//        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
//        sb.append(title);
//        sb.append("\"");
//
//        System.out.println(sb.toString());
        try {
            querySongInfoView.setString(1, title);
            ResultSet results = querySongInfoView.executeQuery(title);

            List<SongArtist> songArtists = new ArrayList<>();
            while(results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }

            return songArtists;

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }


    }

    private int insertArtist(String name) throws SQLException {
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();

        if(results.next()) {
            return results.getInt(1);
        } else {
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert artist!");
            }

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }

    }

    private int insertAlbum(String name, int artistId) throws SQLException {
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();

        if (results.next()) {
            return results.getInt(1);
        } else {
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist!");
            }

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }

    public void insertSong(String title, String artist, String album, int track) throws SQLException {
        try {
            conn.setAutoCommit(false);
            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            ResultSet results = queryAlbum.executeQuery();
                int affectedRows = insertIntoAlbums.executeUpdate();

                if (affectedRows == 1) {
                    conn.commit();
                } else {
                    throw new SQLException("The song insert failed");

//                ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    return generatedKeys.getInt(1);
//                } else {
//                    throw new SQLException("Couldn't get _id for artist");
//                }
            }
        }
        // Need to catch all exceptions
        catch (Exception e){
            System.out.println("Insert song exception " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("Oh boy! Things are really bade");
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
        }

    }
}
