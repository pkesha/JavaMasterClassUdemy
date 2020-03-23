package com.company;

import java.lang.management.PlatformLoggingMXBean;
import java.util.*;

//Playlist does not check for duplicate songs
public class Main {
    private static List<Album> albums = new ArrayList<Album>();

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

        List<Song> playList1 = new ArrayList<Song>();
        //Songs from album in element zero - "Album 1"
        albums.get(0).addSongPlaylist("Song 1", playList1);
        albums.get(0).addSongPlaylist("doggo", playList1);  //Does not exist
        //albums.get(0).addSongPlaylist("Song 1", playList1); //Has already been added
        albums.get(1).addSongPlaylist("dog", playList1);
        albums.get(1).addSongPlaylist(1, playList1); //This should not be added twice

        play(playList1);
    }

    private static void play(List<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0){
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().getSongName());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    //If if it's switching from moving backwards to forwards,
                    //do .next twice
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " +
                                listIterator.next().getSongName());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                    }
                    break;

                case 2:
                    //If it's switching from moving forwards to backwards,
                    //do .previous twice
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().getSongName());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        //Forward is true at start of the playlist by default.
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().getSongName());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().getSongName());
                            forward = true;
                        } else {
                            System.out.println("Reached end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().getSongName());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().getSongName());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Menu choices: ");
        System.out.println("0 - to quit\n" +
                "1 - play next\n" +
                "2 - play previous\n" +
                "3 - replay current\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - remove current song from playlist");
    }

    private static void printList(List<Song> playlist){
        ListIterator<Song> listIterator = playlist.listIterator();
        boolean firstElement = true;
        if ((playlist.size() >= 0)){
            if(firstElement){
                System.out.println(playlist);
                firstElement = false;
            }
            //The first element is shown twice
            listIterator.next();
            while(listIterator.hasNext())
            {
                if(listIterator.hasNext()){
                    System.out.println(listIterator.next().getSongName());
                } else {
                    System.out.println("No more songs - End of list");
                }
            }
        }
    }








}
