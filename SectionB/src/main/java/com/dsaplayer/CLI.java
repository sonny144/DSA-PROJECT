package com.dsaplayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dsaplayer.playlist.Playlist;
import com.dsaplayer.playlist.PlaylistService;
import com.dsaplayer.song.Song;

// Controller for the command line interface.
public class CLI {
    static Scanner sc = new Scanner(System.in);
    static PlaylistService psv = new PlaylistService();
    
    public static void mainMenu() {
        System.out.println(
                "-------------------------------\n"
            +   "DSAPlayer CLI\n"
            +   "-------------------------------\n"
            +   "1 - Playlist management\n"
            +   "2 - Play menu\n"
        );
        
        try {
            System.out.print("Input number of selection: "); int in = sc.nextInt();

            switch (in) {
                case 1:
                    playlistMenu();
                    break;
                case 2:
                    playMenu();
                    break;
                default:
                    System.out.println("Invalid selection!");
                    mainMenu();
                    break;
            } mainMenu();

        } catch(InputMismatchException ex) {
            System.out.println("Invalid input type!");
            sc.nextLine();
            mainMenu();
        }
    }

    public static void playlistMenu() {
        System.out.println(
                "-------------------------------\n"
            +   "Playlist Manager\n"
            +   "-------------------------------\n"
            +   "0 - Return to main menu\n"
            +   "1 - List all playlists\n"
            +   "2 - List all songs in playlist\n"
            +   "3 - Search for song/artist in playlist\n"
            +   "4 - Create new playlist\n"
            +   "5 - Add new song to playlist\n"
            +   "6 - Remove song from playlist\n"
            +   "99- [DEBUG] Create sample playlist with 100 songs\n"
        );
        
        try {
            System.out.print("Input number of selection: "); int in = sc.nextInt();

            switch (in) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    if(App.plGlobal.isEmpty() == true) {System.out.println("No playlists available!"); break;}
                    for(int i = 0; i <= App.plGlobal.size() - 1; i++) {
                        System.out.println(i+" - "+psv.givePlaylist(i).getPlname());
                    }
                    break;
                case 2:
                    System.out.print("Input playlist name: ");
                    Playlist pldump = psv.findPlaylistByName(sc.next());
                    if (pldump == null) {System.out.print("No hits found!"); break;}

                    psv.dumpSongsInPlaylist(pldump);
                    break;
                case 3:
                    System.out.print("Input playlist name: ");
                    Playlist plSearch = psv.findPlaylistByName(sc.next());
                    System.out.print("Input keyword: ");
                    String key = sc.next();

                    psv.searchPlaylist(plSearch, key);
                    break;
                case 4:
                    System.out.print("Input playlist name: ");
                    Playlist plnNew = new Playlist(); plnNew.setPlname(sc.next());    // Creates new playlist *object* with name inputted; no nodes!
                    App.plGlobal.add(plnNew);

                    System.out.println("Playlist created! Add songs in the menu.");
                    break;
                case 5:
                    System.out.print("Input playlist name to add to: ");
                    Playlist plAdd = psv.findPlaylistByName(sc.next());
                    if (plAdd == null) {System.out.print("No hits found!"); break;}
                    System.out.print("Input song name and artist: ");
                    Song newSong = new Song(sc.next(), sc.next());
                    
                    plAdd.addNode(newSong);
                    System.out.println("Song added successfully!");
                    break;
                case 6:
                    System.out.print("Input playlist name to remove from: ");
                    Playlist plDel = psv.findPlaylistByName(sc.next());
                    if (plDel == null) {System.out.print("No hits found!"); break;}
                    System.out.print("Input song name and artist: ");
                    String keyname = sc.next(); String keyart = sc.next();
                    if (psv.findSong(plDel, keyname, keyart) == null) {System.out.print("No hits found!"); break;}
                    
                    psv.deleteSong(psv.findSongParent(plDel, keyname, keyart));
                    System.out.println("Song removed successfully!");
                    break;
                case 99:
                    System.out.print("Input playlist name: ");
                    Playlist pldbg = new Playlist(); pldbg.setPlname(sc.next());
                    
                    for(int i = 0; i <= 100; i++) {
                        Song dbgSong = new Song("song"+Integer.toString(i), "artist"+Integer.toString(i)); // Automatically defines e.g. song1, song2, etc.
                        pldbg.addNode(dbgSong);
                    }

                    App.plGlobal.add(pldbg);

                    System.out.println("Debug playlist created!\n");
                    break;
                default:
                    System.out.println("Invalid selection!");
                    break;
            } playlistMenu();

        } catch(InputMismatchException ex) {
            System.out.println("Invalid input type!");
            sc.nextLine();
            playlistMenu();
        }
    }

    public static void playMenu() {
        System.out.println(
                "-------------------------------\n"
            +   "Play Menu\n"
            +   "-------------------------------\n"
            +   "0 - Return to main menu\n"
            +   "1 - Play (linear)\n"
            +   "2 - Play (loop)\n"
        );

        try {
            System.out.print("Input number of selection: "); int in = sc.nextInt();

            switch (in) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    playMenu();
                    break;
                case 2:
                    playMenu();
                    break;
                default:
                    System.out.println("Invalid selection!");
                    mainMenu();
                    break;
            } playMenu();
            
        } catch(InputMismatchException ex) {
            System.out.println("Invalid input type!");
            sc.nextLine();
            playMenu();
        }
    }
}

