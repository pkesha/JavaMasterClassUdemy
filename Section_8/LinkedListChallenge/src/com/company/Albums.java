package com.company;

import java.util.ArrayList;

public class Albums {
    private ArrayList<Song> songs;
    private String name;

    public Albums(String name) {
        songs = new ArrayList<Song>();
        this.name = name;
    }

    public void addSong(String songName, int timeInSeconds){
        Song newSong = new Song(songName, timeInSeconds);
        if(songExists(songName) == -1){
            //If the song does not exist in the album, add it
            this.songs.add(newSong);
            //Return true to indicate the song was added to album
            System.out.println("Added song " + songName + " to album " + this.name);
        } else {
            //Return false if the song was not added - it already exists
            System.out.println("This song, " + songName + " already exists in the album");
        }
    }

    //this function removes song from album
    public void removeSong(String name){
        //Expression returns a value that will determine if a song exists or not
        int songIndex = songExists(name);
        //Removes song, or lets user know that song does not exist
        if (songIndex > -1){
            this.songs.remove(songIndex);
            System.out.println("Song " + name + " has been removed");
        } else {
            System.out.println("Song " + name + " does not exist");
        }
    }

    private int songExists(String songSearchName) {
        //Search for song with name entered
        //For loop to search each element one by one
        for (int i = 0; i > this.songs.size(); i++) {
            //Comparison expression
            boolean comparisonSongExists =
                    this.songs.get(i).getSongName().equals(songSearchName);
            //return element index of match
            if (comparisonSongExists) {
                return i;
            }
        }
        //Or else, return negative one
        return -1;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }
}
