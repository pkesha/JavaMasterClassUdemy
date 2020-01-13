package com.company;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Album 1");
        album.addSongAlbum("Song 1", 120);
        album.addSongAlbum("4311 2", 150);
        album.addSongAlbum("Song 3", 180);
        albums.add(album);

        Album album1 = new Album("Album 2");
        album1.addSongAlbum("Cat", 123);
        album1.addSongAlbum("dog", 124);
        album1.addSongAlbum("dog", 124);
        albums.add(album1);

        LinkedList<Song> playList1 = new LinkedList<Song>();
        //Songs from album in element zero - "Album 1"
        albums.get(0).addSongPlaylist("Song 1", playList1);
        albums.get(0).addSongPlaylist("doggo", playList1);
        albums.get(0).addSongPlaylist("Song 1", playList1);
        albums.get(1).addSongPlaylist("Cat", playList1);
        albums.get(1).addSongPlaylist(1, playList1);

        play(playList1);
    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0){
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().getSongName());
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " +
                                listIterator.next().getSongName());
                    } else{
                        System.out.println("We have reached the end of the playlist");
                    }
                    break;

                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

            }
        }
    }
}
