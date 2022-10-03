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
   boolean result;
    if(songName!=null&& playListName!=null&&!songslist.isEmpty()&&!playList.isEmpty()){
        int playlistId;
        int songId=0;
        for( Songs song:songslist){
            if(song.getSongName().equalsIgnoreCase(songName)){
                songId=song.getSongID();
                result=true;
                break;
            }}
        if(songId==0){
            throw new Exception("Song is not present in JukeBox");
        } else if (!playList.containsKey(playListName)) {
            throw new Exception("Playlist Name is not present");
        }else{
            playlistId=playList.get(playListName);
            result= playListContentDAO.addSongsToPlayList(songId,playlistId);
        }
    }else {
        throw new Exception("please provide all details");
    }
    return result;
}
public boolean assAlbumToPlaylist(ArrayList<Songs> songslist, Hashtable<String, Integer> playList, String albumName,String playListName) throws Exception{
    boolean result=false;
    if(albumName!=null&&playListName!=null&&!songslist.isEmpty()&&!playList.isEmpty()){
        int playlistId;
        ArrayList<Integer> songIdList=new ArrayList<>();
        for(Songs song:songslist){
            if(song.getAlbum().equalsIgnoreCase(albumName)){
                songIdList.add(song.getSongID());
                break;
            }
        }
        if(songIdList.isEmpty()){
            throw new Exception("Entered Album is Not Present");
        } else if (!playList.containsKey(playListName)) {
            throw new Exception("Given Playlist name is not present");
        }else {
            playlistId=playList.get(playListName);
            for(int id:songIdList){
                result=playListContentDAO.addSongsToPlayList(playlistId,id);
            }
        }
    }else {
        throw new Exception("please provide all details");
    }return result;
}
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
                throw new Exception("Sorry Selected Playlist is Empty ");
            }
        }return songList;
    }
    public boolean deleteContentTable() throws SQLException {
        boolean result=playListContentDAO.deletePlaylistContentTable();
        return result;
    }
}
