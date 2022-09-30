package com.Music.JukeBox.model;

public class Songs {
    private int songID;
    private String songName;
    private String artistName;
    private String genre;
    private String album;
    private float duration;

    public Songs(int songID, String songName, String artistName, String genre, String album, float duration) {
        this.songID = songID;
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.album = album;
        this.duration = duration;
    }

    public Songs(String songName, String artistName, String genre, String album, float duration) {
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.album = album;
        this.duration = duration;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("%6s\t%25s\t%25s\t%10s\t%20s\t\t%6s",songID,songName,artistName,genre,album,duration)+"\n";
    }
}
