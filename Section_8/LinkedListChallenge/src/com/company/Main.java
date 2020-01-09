package com.company;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Album 1");
        album.addSongAlbum("Song 1", 120);
        album.addSongAlbum("4311 2", 150);
        album.addSongAlbum("Song 3", 180);
        albums.add(album);

    }
}
