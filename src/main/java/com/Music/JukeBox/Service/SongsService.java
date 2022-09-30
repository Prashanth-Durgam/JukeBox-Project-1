package com.Music.JukeBox.Service;

import com.Music.JukeBox.DAO.SongsDAO;
import com.Music.JukeBox.model.Songs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class SongsService {
    SongsDAO songsDAO = new SongsDAO();

    private boolean checkSongpresent(String song, ArrayList<Songs> songlist) throws Exception {
       if(song==null||songlist.isEmpty()){
           throw new Exception("Please provide valid inputs");
       } else{
        boolean result = false;
        for (Songs songs : songlist) {
            if (songs.getSongName().equals(song)) {
                result = true;
                break;
            }
        }
        return result;
    } }

    public boolean insertingSongs(Songs song, ArrayList<Songs> songlist) throws Exception {
       if(song==null||songlist.isEmpty()){
           throw new Exception("Please provide valid inputs");
       } else{
        boolean result = false;
        if (checkSongpresent(song.getSongName(), songlist) == false) {
            result = songsDAO.insertSongs(song);
        }
        return result;
    }}

    public ArrayList<Songs> getSongs() throws SQLException {
        ArrayList<Songs> result=songsDAO.selectSongs();
        return result;
    }

    public void displaySongs() throws SQLException {
        ArrayList<Songs> songList = songsDAO.selectSongs();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%6s\t%25s\t%25s\t%10s\t%20s\t\t%10s", "SONG ID", "SONG NAME", "ARTIST NAME", "GENRE", "ALBUM NAME", "DURATION \n");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        for (Songs songs : songList) {
            System.out.println(songs);
        }
    }

    public ArrayList<Songs> getSongsbyAlbumName(String albumName, ArrayList<Songs> songList) throws Exception{
        ArrayList<Songs> songsByAlbum = null;
        if (songList.isEmpty() == false&&albumName!=null) {
            songsByAlbum = new ArrayList<>();
            for (Songs songs : songList) {
                if (songs.getAlbum().equalsIgnoreCase(albumName)) {
                    songsByAlbum.add(songs);
                }
            }
        } else {
            throw new Exception("Please provide valid inputs");
        }
        return songsByAlbum;
    }

    public ArrayList<Songs> getSongBySongName(String songName,ArrayList<Songs> songList) throws Exception{
        ArrayList<Songs> songByName = null;
        if (songList.isEmpty() == false&&songName!=null) {
            songByName = new ArrayList<>();
            for (Songs songs : songList) {
                if (songs.getSongName().trim().equalsIgnoreCase(songName.trim())) {
                    songByName.add(songs);
                    break;
                }
            }
        } else {
            throw new Exception("Please provide valid inputs");
        }
        return songByName;
    }

    public ArrayList<Songs> getSongsbyArtistName(String artistName, ArrayList<Songs> songList) throws Exception{
        ArrayList<Songs> songsByArtist = null;
        if (songList.isEmpty() == false&& artistName!=null) {
            songsByArtist = new ArrayList<>();
            for (Songs songs : songList) {
                if (songs.getArtistName().contains(artistName)) {
                    songsByArtist.add(songs);
                }
            }
        } else {
            throw new Exception("Please provide valid inputs");
        }
        return songsByArtist;
    }

    public ArrayList<Songs> getSongsbyGenre(String genre, ArrayList<Songs> songList) throws Exception{
        ArrayList<Songs> songsByGenre = null;
        if (songList.isEmpty() == false && genre!=null) {
            songsByGenre = new ArrayList<>();
            for (Songs songs : songList) {
                if (songs.getGenre().equalsIgnoreCase(genre)) {
                    songsByGenre.add(songs);
                }
            }
        } else {
            throw new Exception("Please provide valid inputs");
        }
        return songsByGenre;
    }
    public boolean deleteSongTable() throws SQLException {
        boolean result=songsDAO.deleteSongtable();
        return result;
    }
}

