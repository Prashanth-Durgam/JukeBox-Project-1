package com.Music.JukeBox.Implementation;

import com.Music.JukeBox.Service.PlayListContentService;
import com.Music.JukeBox.Service.PlayListService;
import com.Music.JukeBox.Service.PlayerService;
import com.Music.JukeBox.Service.SongsService;
import com.Music.JukeBox.model.Songs;

import javax.sound.midi.Soundbank;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class MainMethod {
    void displayMenu(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Please select appropriate option below : ");
        System.out.println("--------------------------------------------------------");
        System.out.println("1		Song\n2		Playlist\n3		Player\n4		Exit\n5		Delete All the Database Content");
        System.out.println("--------------------------------------------------------");}
    void displaySongmenu(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Please select appropriate option below : ");
        System.out.println("--------------------------------------------------------");
        System.out.println("1		Add song\n2		Search Song By Song Name\n3		Search Song By Genre\n4		Search Song By Album\n5		Search Song By Artist\n6		Main Menu\n7		Exit");
        System.out.println("--------------------------------------------------------");}
    void displayPlayListmenu(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Please select appropriate option below : ");
        System.out.println("--------------------------------------------------------");
        System.out.println("1		All PlayLists\n2		Create PlayList\n3		Add Song to PlayList\n4		Add Album to PlayList\n5		Display PlayList Content\n6		Main Menu\n7		Exit");
        System.out.println("--------------------------------------------------------");}
    void formatting(){
        System.out.format("%6s\t%25s\t%25s\t%10s\t%20s\t\t%10s", "SONG ID", "SONG NAME", "ARTIST NAME", "GENRE", "ALBUM NAME", "DURATION \n");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }
    void playermenu(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Please select appropriate option below : ");
        System.out.println("--------------------------------------------------------");
        System.out.println("1		Pause\n2		Resume\n3		Jump\n4		Restart\n5		Next Song");
        System.out.println("--------------------------------------------------------");}
        public static void main(String[] args) throws Exception {
        MainMethod obj = new MainMethod();
        Scanner scanner=new Scanner(System.in);
        SongsService songsService = new SongsService();
        PlayListService playListService = new PlayListService();
        PlayListContentService playListContentService = new PlayListContentService();
        PlayerService playerService=new PlayerService();
            char ans;
            char ans1;
            char ans2;
        try {
            Hashtable<String, Integer> playList;
            ArrayList<Songs> sList;
            System.out.println();
            System.out.println("-------------------------------------------$ Welcome to JukeBox $-------------------------------------------------------");
            System.out.println("-------------------------------------$ Where words fail Music Speaks $--------------------------------------------------");
            System.out.println("-------------------$$ My name is Jukebox. I own thousands and thousands and thousands of songs $$-----------------------");
            System.out.println();
            songsService.displaySongs();
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            do{
            obj.displayMenu();
            int option=scanner.nextInt();
            switch (option) {
                case 1:
                    do{
                        sList = songsService.getSongs();
                        obj.displaySongmenu();
                        int SongOption = scanner.nextInt();
                        switch (SongOption) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Please Enter Song Name: ");
                            System.out.println("--------------------------------------------------------");
                            String songName = scanner.nextLine();
                            System.out.println("Please Enter The Artist Name");
                            System.out.println("--------------------------------------------------------");
                            String artistName = scanner.nextLine();
                            System.out.println("Please Enter The Genre");
                            System.out.println("--------------------------------------------------------");
                            String genre = scanner.nextLine();
                            System.out.println("Please Enter The Album");
                            System.out.println("--------------------------------------------------------");
                            String album = scanner.nextLine();
                            System.out.println("Please Enter the Duration");
                            System.out.println("--------------------------------------------------------");
                            float duration = scanner.nextFloat();
                            Songs songs = new Songs(songName, artistName, genre, album, duration);
                            songsService.insertingSongs(songs, sList);
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Updated JukeBox Songs List is: ");
                            songsService.displaySongs();
                            break;
                        case 2:
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Please Enter The Song that you wanted to search");
                            System.out.println("------------------------------------------------------------------------------------------------------------------------");
                            scanner.nextLine();
                            String song = scanner.nextLine();
                            System.out.println("--------------------------------------------------------");
                            ArrayList<Songs> songs2= songsService.getSongBySongName(song, sList);
                            if(!songs2.isEmpty()){
                            obj.formatting();
                            for(Songs songs1: songs2)
                            System.out.println(songs1);}
                            else {
                                System.out.println("Sorry Song Not Present in JukeBox Please Try again..!");
                            }
                            break;
                        case 3:
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Please Enter the Genre that you wanted to search");
                            System.out.println("------------------------------------------------------------------------------------------------------------------------");
                            scanner.nextLine();
                            String genre1 = scanner.nextLine();
                            System.out.println("--------------------------------------------------------");
                            ArrayList<Songs> genre2 = songsService.getSongsbyGenre(genre1, sList);
                            if(!genre2.isEmpty()){
                            obj.formatting();
                            for(Songs gen: genre2)
                            System.out.println(gen);}
                            else{
                                System.out.println("Sorry Genre Not present In JukeBox Please Try again..!");
                            }
                            break;
                        case 4:
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Please Enter the Album that you wanted to search");
                            System.out.println("------------------------------------------------------------------------------------------------------------------------");
                            scanner.nextLine();
                            String album1 = scanner.nextLine();
                            System.out.println("--------------------------------------------------------");
                            ArrayList<Songs> album2 = songsService.getSongsbyAlbumName(album1, sList);
                            if(!album2.isEmpty()){
                            obj.formatting();
                            for(Songs albums: album2)
                            System.out.println(albums);}
                            else {
                                System.out.println("Sorry Album Not present In JukeBox Please Try again..!");
                            }
                            break;
                        case 5:
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Please Enter the Artist that you wanted to search");
                            System.out.println("------------------------------------------------------------------------------------------------------------------------");
                            scanner.nextLine();
                            String artist = scanner.nextLine();
                            System.out.println("--------------------------------------------------------");
                            ArrayList<Songs> artist1 = songsService.getSongsbyArtistName(artist, sList);
                            if(!artist1.isEmpty()){
                            obj.formatting();
                            for(Songs artists: artist1)
                            System.out.println(artists);}
                            else{
                                System.out.println("Sorry Artist Not present In JukeBox Please Try again..!");
                            }
                            break;
                        case 6:
                            System.out.println("Returning to Main Menu");
                            break;
                        case 7:
                            System.out.println("------------------------Thank you-------------------------");
                            System.out.println("---------------------Have A Great Day----------------------");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Sorry you have selected the wrong option: \n");
                    }
                            System.out.println("------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Enter 'y' to continue to Songs Menu : ");
                            System.out.println("--------------------------------------------------------");
                            ans1 = scanner.next().charAt(0);
                    } while (ans1=='y');
                    break;

                case 2:
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    do{
                         playList = playListService.getAllPlaylist();
                         sList = songsService.getSongs();
                         obj.displayPlayListmenu();
                         int playListOption = scanner.nextInt();
                         switch (playListOption) {
                             case 1:
                                 Set<String> playListNames = playList.keySet();
                                 System.out.println("--------------------------------------------------------");
                                 System.out.println("PlayList's Present in our JukeBox");
                                 System.out.println("--------------------------------------------------------");
                                 for(String plist: playListNames)
                                     System.out.println(plist);
                                 break;
                             case 2:
                                scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Please Enter the PlayList name that you wanted to add");
                                System.out.println("--------------------------------------------------------");
                                String name1 = scanner.nextLine();
                                boolean result = playListService.addPlaylist(name1, playList);
                                System.out.println("--------------------------------------------------------");
                                if (result) {
                                    System.out.println("PlayList Successfully Added");
                                    System.out.println("--------------------------------------------------------");
                                    playListService.displayPlayList();}
                                else {
                                    System.out.println("PlayList Already Exists in Juke Box Please try with other name");
                                }
                                System.out.println("--------------------------------------------------------");
                                break;
                             case 3:
                                scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Please Enter the Song to Add");
                                System.out.println("--------------------------------------------------------");
                                String song = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter the PlayList Name: ");
                                System.out.println("--------------------------------------------------------");
                                String playlisname = scanner.nextLine();
                                boolean check = playListContentService.addSongsPlaylist(sList, playList, song, playlisname);
                                System.out.println("--------------------------------------------------------");
                                if (check) {
                                    System.out.println(song + " Added to playlist " + playlisname);}
                                System.out.println("--------------------------------------------------------");
                                break;
                             case 4:
                                scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Please Enter the Album to Add");
                                System.out.println("--------------------------------------------------------");
                                String album = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter the PlayList Name: ");
                                System.out.println("--------------------------------------------------------");
                                String playlisname1 = scanner.nextLine();
                                boolean check1 = playListContentService.assAlbumToPlaylist(sList, playList, album, playlisname1);
                                System.out.println("--------------------------------------------------------");
                                if (check1) {
                                    System.out.println(album + " Added to playlist " + playlisname1);}
                                System.out.println("--------------------------------------------------------");
                                break;
                             case 5:
                                scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Please Enter the Play List Name");
                                System.out.println("--------------------------------------------------------");
                                String playlistName = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                ArrayList<Songs> playListContent = playListContentService.playListContent(playlistName, playList, sList);

                                if(!playListContent.isEmpty())
                                {obj.formatting();
                                for(Songs playContent: playListContent)
                                    System.out.println(playContent); }
                                break;
                             case 6:
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Returing to Main-Menu");
                                break;
                             case 7:
                                System.out.println("------------------------Thank you-------------------------");
                                System.out.println("---------------------Have A Great Day----------------------");
                                System.exit(0);
                                break;
                             default:
                                System.out.println("Sorry you have selected the wrong option: \n");
                         }
                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter 'y' to continue to PlayList Menu : ");
                        System.out.println("--------------------------------------------------------");
                        ans2 = scanner.next().charAt(0);
                    }while (ans2=='y');
                    break;
                case 3:
                    playList = playListService.getAllPlaylist();
                    sList = songsService.getSongs();
                    char next;
                    int id;
                    do{
                        boolean quit = false;
                        System.out.println("Please Enter the PlayList Name That you wanted to Play");
                        scanner.nextLine();
                        String playlistName=scanner.nextLine();
                        ArrayList<Songs> playlistSongs= playListContentService.playListContent(playlistName,playList,sList);
                        Iterator<Songs> iterator = playlistSongs.iterator();
                         id=iterator.next().getSongID();
                         playerService.playSongs(id);
                             while (!quit){
                                 obj.playermenu();
                                 int action = scanner.nextInt();
                                 scanner.nextLine();
                                 switch (action){
                                    case 1: playerService.pause();
                                            break;
                                    case 2: playerService.resume(id);
                                            break;
                                    case 3:playerService.jump();
                                            break;
                                    case 4:playerService.restart(id);
                                            break;
                                    case 5: if(iterator.hasNext()){
                                            id = iterator.next().getSongID();
                                            playerService.stop();
                                            playerService.playSongs(id); }
                                        else {
                                            playerService.stop();
                                            System.out.println("There is No Next Song Available in PlayList");
                                            quit=true;
                                        }
                                        break;
                                     case 6: playerService.play();
                                    }
                             }
                        System.out.println("Do you want to continue to another Playlist? prees 'y' ");
                        next=scanner.next().charAt(0);
                }while (next=='y'); break;

                case 4:
                    System.out.println("------------------------Thank you-------------------------");
                    System.out.println("--------I'll be Waiting for you until we meet again---------");
                    System.out.println("---------------------Have A Great Day----------------------");
                    System.exit(0);
                    break;
                case 5:
                            boolean deleteContent=playListContentService.deleteContentTable();
                            if(deleteContent)
                                System.out.println("All PlayList Songs deleted Sucessfully");
                            else{
                                System.out.println("There is No Data delete in Playlist's ");}
                            boolean deleteplaylits=playListService.deletePlayListTable();
                            if(deleteplaylits)
                                System.out.println("All PlayList's Deleted Sucessfully");
                            else{
                                System.out.println("There Are No Playlist's to Delete");}
                            boolean deletesongs=songsService.deleteSongTable();
                            if(deletesongs)
                                System.out.println("All Songs Deleted sucessfully");
                            else{
                                System.out.println("There Are No Songs to Delete");}
                            break;
                }
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Enter 'y' to continue to Main Menu: ");
                System.out.println("--------------------------------------------------------");
                ans = scanner.next().charAt(0);
            }
            while (ans=='y');
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
