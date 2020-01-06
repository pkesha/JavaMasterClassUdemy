package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Playlist {
    private LinkedList<Song> songs;
    private String name;

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public Playlist(LinkedList<Song> songs, String name) {
        this.songs = new LinkedList<Song>();
        this.name = name;
    }

    public void addSong(String songName, int timeInSeconds){
        Song newSong = new Song(songName, timeInSeconds);
        if(songExists(songName)){
            System.out.println("Song " + songName + " exists.  Can't be added");
        } else{
            this.songs.add(newSong);
        }
    }

    private boolean songExists(String name){
        Iterator<Song> i = this.songs.iterator();
        while(i.hasNext()){
            //Setting it element zero
            //This is because the element at the cursor set by iterator should
            //be element zero in the linkedlist
            if (this.songs.get(0).getSongName().equals(name)){
                return true;
            } else{
                i.next();
            }
        }
        return false;
    }
}
