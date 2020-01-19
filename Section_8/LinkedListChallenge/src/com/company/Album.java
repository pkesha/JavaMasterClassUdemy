package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private ArrayList<Song> songsAlbums;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songsAlbums = new ArrayList<Song>();
    }

    private Song findSongAlbum(String title){
        for (Song checkedSong: this.songsAlbums){
<<<<<<< HEAD
            //System.out.println(checkedSong.getSongName());
            //System.out.println("Boolean: " + (checkedSong.getSongName() == title));

            //Shows as false but returns the 1st value for checked song after the first element is added
            if(checkedSong.getSongName().equals(title)){
                //System.out.println("Song checked: " + checkedSong.getSongName());
                //System.out.println("Input song: " + title);
=======

            if(checkedSong.getSongName() == title){
>>>>>>> 6fd4aa82d3a7803cf14ba91d40c674b36b4e5206
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addSongAlbum(String songName, int timeSeconds){
        Song newSong = new Song(songName, timeSeconds);
        if(findSongAlbum(songName) == null){
            this.songsAlbums.add(newSong);
            System.out.println("The song '" + songName + "' was added to album " +
                    this.albumName);
            return true;
        } else {
<<<<<<< HEAD
            //System.out.println("BOOLEAN: " + findSongAlbum(songName).getSongName());
            System.out.println("Song " + songName + " already exists");
=======
            System.out.println("The song '" + songName + "' already exists");
>>>>>>> 6fd4aa82d3a7803cf14ba91d40c674b36b4e5206
            return false;
        }
    }

    //Using track number (index from Album array list) to add to playlist.
    public boolean addSongPlaylist(int trackNumber, LinkedList<Song> songsPlaylist){
        int index = trackNumber - 1;
        if ((this.songsAlbums.size() >= index) &&
                (index >= 0) &&
                (!songsPlaylist.contains(this.songsAlbums.get(index)))){
            //Adding to linkedlist.  No, the index is not relevant for linkedlist
            //Just for choosing which song to add in the albums arraylist
            songsPlaylist.add(this.songsAlbums.get(index));
            return true;
        }
        System.out.println("This album exists but does not contain any songs");
        return false;
    }

    public boolean addSongPlaylist(String name, LinkedList<Song> songsPlaylist){
        Song addSong = findSongAlbum(name);
        if(addSong != null){
            songsPlaylist.add(addSong);
            return true;
        } else{
            System.out.println("Did not find song '" + name + "'");
            return false;
        }
    }

    public boolean removeSongAlbum(String songName){
        Song removeSong = findSongAlbum(songName);

        if (removeSong != null){
            this.songsAlbums.remove(removeSong);
            System.out.println("The song '" + songName + "' was removed");
            return true;
        }
        System.out.println("The song '" + songName + "' was not found");
        return false;
    }
}

