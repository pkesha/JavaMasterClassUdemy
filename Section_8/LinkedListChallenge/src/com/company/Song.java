package com.company;

public class Song {
    private String songName;
    private int durationInSeconds;

    public Song(String songName, int durationInSeconds) {
        this.songName = songName.toLowerCase();
        this.durationInSeconds = durationInSeconds;
    }

    public String getSongName() {
        return songName;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }


}
