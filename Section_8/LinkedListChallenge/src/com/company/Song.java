package com.company;

public class Song {
    private String songName;
    private int timeSeconds;

    public String getSongName() {
        return songName;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public Song(String songName, int timeSeconds) {
        this.songName = songName;
        this.timeSeconds = timeSeconds;
    }
}