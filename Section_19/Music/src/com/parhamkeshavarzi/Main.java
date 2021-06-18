package com.parhamkeshavarzi;

import model.Artist;
import model.DataSource;
import model.SongArtist;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new DataSource();
        if(!dataSource.open()) {
            System.out.println("Can't open database");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_ASC);
        if(artists == null) {
            System.out.println("No artists!");
            return;
        }

        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist =
                dataSource.queryAlbumsForArtist("Iron Maiden", DataSource.ORDER_BY_ASC);

        for(String album : albumsForArtist){
            System.out.println(album);
        }

        List<SongArtist> songArtists = dataSource.queryArtistsForSong("Heartless", DataSource.ORDER_BY_ASC);
        if(songArtists != null){
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("Artists name = " + artist.getAlbumName() +
                    " Track = " + artist.getTrack());
        }

        int count = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of song is: " + count);

        dataSource.createViewForSongArtists();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();
        songArtists = dataSource.querySongInfoView(title);
        if(songArtists.isEmpty()){
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    "Album name = " + artist.getAlbumName() +
                    "Track number = " + artist.getTrack());
        }

        dataSource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);
        dataSource.close();
    }

}
