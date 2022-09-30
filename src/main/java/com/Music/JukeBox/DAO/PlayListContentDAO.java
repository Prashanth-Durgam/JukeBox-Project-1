package com.Music.JukeBox.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayListContentDAO {
    public boolean addSongsToPlayList(int songID,int playlistId)throws SQLException {
        PreparedStatement addSongsPlayList = JukeBoxConnection.getJukeBoxConnection().prepareStatement("insert into PlayListContent values(?,?);");
        addSongsPlayList.setInt(1, playlistId);
        addSongsPlayList.setInt(2, songID);
        int check = addSongsPlayList.executeUpdate();
        return check>0?true:false;
    }
    public ArrayList<Integer> viewSongsInPlayList(int playlistID) throws SQLException{
        ArrayList<Integer> songID = new ArrayList<>();
        PreparedStatement viewSongsPlaylist = JukeBoxConnection.getJukeBoxConnection().prepareStatement("select*from PlayListContent where PlayListId=?;");
        viewSongsPlaylist.setInt(1,playlistID);
        ResultSet resultSet = viewSongsPlaylist.executeQuery();
        while (resultSet.next()){
            songID.add(resultSet.getInt(2));
        }
        return songID;
    }
    public boolean deletePlaylistContentTable() throws SQLException{
        Statement deletePlaylistContentTable=JukeBoxConnection.getJukeBoxConnection().createStatement();
        int check=deletePlaylistContentTable.executeUpdate("delete from PlayListContent;");
        return check>0?true:false;
    }
}
