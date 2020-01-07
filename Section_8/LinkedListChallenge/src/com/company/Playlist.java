package com.company;

import javax.sound.midi.Soundbank;
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
        if(songExists(songName) != null){
            System.out.println("Song " + songName + " exists.  Can't be added");
        } else{
            this.songs.add(newSong);
        }
    }

    public void removeSong(String songName){
        if(songExists(songName) != null){
            System.out.println("Song removed: " + this.songs.element().getSongName());
            this.songs.remove(0);
        } else {
            System.out.println("Song does not exist");
        }
    }

    public void playSong(){
        
    }

    private Iterator<Song> songExists(String name){
        Iterator<Song> i = this.songs.iterator();
        while(i.hasNext()){
            //Setting it element zero
            //This is because the element at the cursor set by iterator should
            //be element zero in the linkedlist
            if (this.songs.get(0).getSongName().equals(name)){
                System.out.println(this.songs.get(0));
                return this.songs.iterator();
            } else{
                i.next();
            }
        }
        return null;
    }
}
