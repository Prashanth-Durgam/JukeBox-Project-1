import com.Music.JukeBox.DAO.SongsDAO;
import com.Music.JukeBox.Service.SongsService;
import com.Music.JukeBox.model.Songs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class SongsServiceTest {
    SongsService songsService;
    @Before
    public void setup(){
        songsService = new SongsService();
    }
    @After
    public void teardown(){
        songsService = null;
    }
   @Test
  public void getSongbyname() throws Exception {
        ArrayList<Songs> songs =songsService.getSongs();


    }
  /* @Test
    public void checksongTrue() throws Exception{
        ArrayList<Songs> songs = songsService.getSongs();
        Assert.assertTrue(songsService.insertingSongs("Subh",songs));
   } */

}
