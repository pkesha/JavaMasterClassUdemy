package com.company;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String albumName;
    private SongList songs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new SongList();
    }

    private class SongList {
        private List<Song> songList;
        private String name;
        private int trackNumber;

        public SongList() {
            this.songList = new ArrayList<Song>();
        }
/*
        public boolean add(Song song){
            if(songList.contains(song)){
                return false;
            }
            this.songList.add(song);
            return true;
        }

        public Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if((index > 0) && (index < songList.size())){
                return songList.get(index);
            }
            return null;
        }
*/

        public boolean addSongsPlaylist(String name, List<Song> songsPlaylist) {
            Song addSong = findSongsAlbum(name);
            if (addSong != null) {
                songsPlaylist.add(addSong);
                return true;
            } else {
                System.out.println("Did not find song '" + name + "'");
                return false;
            }
        }

        public boolean addSongsPlaylist(int trackNumber, List<Song> songsPlaylist) {
            int index = trackNumber - 1;
            if ((this.songList.size() >= index) &&
                    (index >= 0) &&
                    (!songsPlaylist.contains(this.songList.get(index)))) {
                //Adding to linkedlist.  No, the index is not relevant for linkedlist
                //Just for choosing which song to add in the albums arraylist
                songsPlaylist.add(this.songList.get(index));
                return true;
            }
            System.out.println("This album exists but does not contain any songs");
            return false;
        }

        public boolean addSongsAlbum(String songName, int timeSeconds) {
            Song newSong = new Song(songName, timeSeconds);
            if (findSongsAlbum(songName) == null) {
                this.songList.add(newSong);
                System.out.println("The song '" + songName + "' was added to album " +
                        this.name);
                return true;
            } else {
                //System.out.println("BOOLEAN: " + findSongAlbum(songName).getSongName());
                System.out.println("Song " + songName + " already exists");
                System.out.println("The song '" + songName + "' already exists");
                return false;
            }
        }

        private Song findSongsAlbum(String title) {
            for (Song checkedSong : this.songList) {
                //System.out.println(checkedSong.getSongName());
                //System.out.println("Boolean: " + (checkedSong.getSongName() == title));
                //Shows as false but returns the 1st value for checked song after the first element is added
                if (checkedSong.getSongName().equals(title)) {
                    //System.out.println("Song checked: " + checkedSong.getSongName());
                    //System.out.println("Input song: " + title);
                    return checkedSong;
                }
            }
            return null;
        }
    }



    public boolean addSongAlbum(String songName, int timeSeconds) {
        //System.out.println(this.songs.addSongsAlbum(songName, timeSeconds));
        return this.songs.addSongsAlbum(songName, timeSeconds);
    }

        //Using track number (index from Album array list) to add to playlist.
    public boolean addSongPlaylist(int trackNumber, List<Song> songsPlaylist){
        return this.songs.addSongsPlaylist(trackNumber, songsPlaylist);
    }

    public boolean addSongPlaylist (String name, List <Song> songsPlaylist){
        return this.songs.addSongsPlaylist(name, songsPlaylist);
    }

    public boolean removeSongAlbum (String songName){
        Song removeSong = this.songs.findSongsAlbum(songName);

        if (removeSong != null) {
            this.songs.songList.remove(removeSong);
            System.out.println("The song '" + songName + "' was removed");
            return true;
        }
        System.out.println("The song '" + songName + "' was not found");
        return false;
    }
}

