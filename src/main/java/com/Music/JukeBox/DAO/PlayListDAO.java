package com.Music.JukeBox.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

public class PlayListDAO {
    public boolean CreatePlayList(String playListName) throws SQLException {
        PreparedStatement createPlayList = JukeBoxConnection.getJukeBoxConnection().prepareStatement("insert into PlayList(playListName) values(?);");
        createPlayList.setString(1, playListName);
        int check = createPlayList.executeUpdate();
        return check>0?true:false;
    }
    public Hashtable<String, Integer> viewAllPlaylist() throws SQLException{
        Hashtable<String, Integer> playList = new Hashtable<>();
        Statement statement = JukeBoxConnection.getJukeBoxConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select*from PlayList");
        while (resultSet.next()){
            playList.put(resultSet.getString(2),resultSet.getInt(1));
        }
        return playList;
    }
    public boolean deletePlaylisttable() throws SQLException{
        Statement deletePlaylistable=JukeBoxConnection.getJukeBoxConnection().createStatement();
        int check=deletePlaylistable.executeUpdate("delete from PlayList;");
        return check>0?true:false;
    }
}
