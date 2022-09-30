package com.Music.JukeBox.DAO;

import com.Music.JukeBox.model.Songs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SongsDAO {
    public boolean insertSongs(Songs songs) throws SQLException{
        PreparedStatement songInsert=JukeBoxConnection.getJukeBoxConnection().prepareStatement("insert into Songs(songName,artistName,genre,album,duration) values(?,?,?,?,?);");
        songInsert.setString(1, songs.getSongName());
        songInsert.setString(2, songs.getArtistName());
        songInsert.setString(3, songs.getGenre());
        songInsert.setString(4, songs.getAlbum());
        songInsert.setFloat(5, songs.getDuration());
        int check = songInsert.executeUpdate();
        return check>0?true:false;
    }
public ArrayList<Songs> selectSongs() throws SQLException{
    ArrayList<Songs> songslist = new ArrayList<>();
    Statement statement = JukeBoxConnection.getJukeBoxConnection().createStatement();
    ResultSet resultSet = statement.executeQuery("select*from Songs");
    while (resultSet.next()){
        songslist.add(new Songs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getFloat(6)));
    }
    return songslist;
}
public boolean deleteSongtable() throws SQLException{
Statement deleteSongtable=JukeBoxConnection.getJukeBoxConnection().createStatement();
int check=deleteSongtable.executeUpdate("delete from Songs;");
return check>0?true:false;
}
}
