package com.Music.JukeBox.Service;

import com.Music.JukeBox.DAO.PlayListContentDAO;
import com.Music.JukeBox.model.Songs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class PlayListContentService {

PlayListContentDAO playListContentDAO = new PlayListContentDAO();
public boolean addSongsPlaylist(ArrayList<Songs> songslist, Hashtable<String, Integer> playList, String songName, String playListName) throws Exception {
    boolean result = false;
    if(songslist.isEmpty()||playList.isEmpty()||songName==null||playListName==null){
       throw new JukeBoxException("Please provide all the required values");}
    else  {
        int playlistID = playList.get(playListName);
        int songID = 0;
        for (Songs songId : songslist) {
            if(songId.getSongName().equalsIgnoreCase(songName)){
                songID = songId.getSongID();
                result=true;
                break;
            } }
            if (songID == 0) {
                throw new JukeBoxException("The given SongID not there");
            } else if (playlistID == 0) {
                throw new JukeBoxException("the playlist is not there");

            } else {
                result = playListContentDAO.addSongsToPlayList(songID, playlistID);
            }
        }
    return result;}
public boolean assAlbumToPlaylist(ArrayList<Songs> songslist, Hashtable<String, Integer> playList, String albumName,String playListName) throws Exception{
 boolean result = false;
 if(songslist.isEmpty()||playList.isEmpty()||albumName==null||playListName==null) {
 throw new Exception("Please provide all the required values");}
 else{
     int playlistID = playList.get(playListName.trim());
     ArrayList<Integer> songIdList = new ArrayList<>();
     for(Songs songs:songslist){
         if(songs.getAlbum().trim().equalsIgnoreCase(albumName.trim())){
             songIdList.add(songs.getSongID());
             result=true;
         }
     }
     if(playlistID==0){
       throw new Exception("Playlist Not Present");
     } else if (songIdList.isEmpty()) {throw new Exception("Song ID not present");}
     else { for(int id:songIdList){
         result=playListContentDAO.addSongsToPlayList(id,playlistID);
     }}
 }
    return result;}
    public ArrayList<Songs> playListContent(String playListName,Hashtable<String, Integer> playList,ArrayList<Songs> songslist)throws Exception{
        ArrayList<Integer> songIdList;
        ArrayList<Songs> songList = null;
        if(playListName==null||playList.isEmpty()||songslist.isEmpty()){
            throw new Exception("Please provide all the required values");}
        else {
            int playListId=0;
            if(playList.containsKey(playListName)==false)
            {throw new Exception("PlayList is Not Present in JukeBox");}
            else {
                playListId=playList.get(playListName);
                songIdList=playListContentDAO.viewSongsInPlayList(playListId);}
            if(songIdList.isEmpty()==false){
                songList = new ArrayList<>();
                for(int id: songIdList){
                    for(Songs songs:songslist){
                        if(songs.getSongID()==id)
                            songList.add(songs);
                    }
                }
            } else {
                throw new Exception(" Sorry Playlist is Empty ");
            }
        }return songList;
    }
    public boolean deleteContentTable() throws SQLException {
        boolean result=playListContentDAO.deletePlaylistContentTable();
        return result;
    }
}
