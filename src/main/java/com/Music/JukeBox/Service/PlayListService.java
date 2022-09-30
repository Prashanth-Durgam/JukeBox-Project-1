package com.Music.JukeBox.Service;

import com.Music.JukeBox.DAO.PlayListDAO;
import com.Music.JukeBox.model.Songs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class PlayListService {
    PlayListDAO playListDAO =new PlayListDAO();
    public boolean addPlaylist(String playlistName, Hashtable<String,Integer>playList)throws Exception {
        if(playlistName==null||playList.isEmpty()){
            throw new Exception("Please provide details correctly");
        }else{
        boolean result = false;
        boolean playlistpresent = playList.containsKey(playlistName);
        if(playlistpresent==false){
           result = playListDAO.CreatePlayList(playlistName);
        }return result;
    }
    }
    public Hashtable<String,Integer> getAllPlaylist()throws SQLException{
        Hashtable<String,Integer> result=playListDAO.viewAllPlaylist();
        return result;
    }
    public void displayPlayList() throws SQLException {
        Set<String> playList = getAllPlaylist().keySet();
        for (String playList1 : playList) {
            System.out.println(playList1);
        }
    }
    public boolean deletePlayListTable() throws SQLException {
        boolean result=playListDAO.deletePlaylisttable();
        return result;
    }
}
