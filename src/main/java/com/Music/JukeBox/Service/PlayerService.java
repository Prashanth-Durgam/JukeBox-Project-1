package com.Music.JukeBox.Service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayerService {
    Clip clip;
    long presentFrame;
    String status;
    public void playSongs(int id)throws IOException, UnsupportedAudioFileException, LineUnavailableException{
        AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(new File("src/main/resources/"+id+".wav"));
        clip=AudioSystem.getClip();
        clip.open(audioInputStream);
       // play();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
   public void play()
    {
        clip.start();
        System.out.println("Song is Playing Sucessfully");
        status="play";
    }
    public void pause(){
        presentFrame=clip.getMicrosecondLength();
        clip.stop();
        System.out.println("Song is paused......!");
        status="paused";
    }
    public void resume(int id) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
       if(status.equals("play")){
           System.out.println("Song is Alraedy Playing..!!");
           return;
       }
        clip.close();
        resetAudio(id);
        clip.setMicrosecondPosition(presentFrame);
        this.play();
    }
    public void restart(int id) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();
        resetAudio(id);
        presentFrame=0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }
    public void stop(){
        presentFrame=0L;
        clip.stop();
        clip.close();
    }
    public void jump(){
        clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 5000000);
    }
   public void resetAudio( int id) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/" + id + ".wav"));
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
