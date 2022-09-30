import com.Music.JukeBox.DAO.SongsDAO;
import com.Music.JukeBox.model.Songs;
import com.sun.source.tree.AssertTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class SongsDAOTest {
    SongsDAO songsDAO;
    @Before
    public void setup(){
        songsDAO = new SongsDAO();
    }
    @After
    public void teardown(){
        songsDAO = null;
    }
    @Test
    public void CheckingInsertion() throws SQLException {
        Songs song1 = new Songs(2003, "Oh sita Hey Rama", "SPB Charan", "Pop", "Sita Ramam", 4.55f);
        Assert.assertNotEquals("Duplicate entry '2003' for key 'songs.PRIMARY'",songsDAO.insertSongs(song1));
    }
    @Test
    public void selectAllSongs() throws SQLException{
        ArrayList<Songs> songsList = songsDAO.selectSongs();
        Assert.assertNotNull(songsList);
    }
}
