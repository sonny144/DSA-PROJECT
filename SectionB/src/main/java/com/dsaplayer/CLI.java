package com.dsaplayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dsaplayer.playlist.Playlist;
import com.dsaplayer.playlist.Service;
import com.dsaplayer.song.Song;

// Controller for the command line interface.
public class CLI {
    static Scanner sc = new Scanner(System.in);
    static Service sv = new Service();
    
    public static void mainMenu() {
        System.out.println(
                "---------------\n"
            +   "DSAPlayer CLI\n"
            +   "---------------\n"
            +   "1 - Playlist management\n"
            +   "2 - Play menu\n"
        );
        
        try {
            int in = sc.nextInt();

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
            mainMenu();
        }
    }

    public static void playlistMenu() {
        System.out.println(
                "---------------\n"
            +   "Playlist Manager\n"
            +   "---------------\n"
            +   "0 - Return to main menu\n"
            +   "1 - List all playlists\n"
            +   "2 - List all songs in playlist\n"
            +   "3 - Search for song in playlist\n"
            +   "4 - Create new playlist\n"
            +   "5 - Add new song to playlist\n"
            +   "6 - Remove song from playlist\n"
            +   "99- [DEBUG] Create sample playlist with 100 songs\n"
        );
        
        try {
            int in = sc.nextInt();

            switch (in) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    playlistMenu();
                    break;
                case 2:
                    playMenu();
                    break;
                case 3:
                    playMenu();
                    break;
                case 4:
                    // TODO: this needs to generate anonymous objects!!
                    System.out.print("Input playlist name: ");
                    Playlist pln = new Playlist(); pln.setPlname(sc.next());    // Creates new playlist *object* with name inputted; no nodes!

                    System.out.println("Playlist created! Add songs in the menu.");
                    break;
                case 5:
                    System.out.print("Input playlist name to add to: ");
                    Playlist plAdd = sv.findPlaylist(sc.next());
                    System.out.print("Input song name and author: ");
                    Song newSong = new Song(sc.next(), sc.next());

                    plAdd.addNode(newSong);
                    System.out.println("Song added successfully!");
                    break;
                case 6:
                    playMenu();
                    break;
                case 99:
                    System.out.print("Input playlist name: ");
                    Playlist pldbg = new Playlist(); pldbg.setPlname(sc.next());
                    
                    for(int i = 0; i < 100; i++) {
                        Song dbgSong = new Song("song"+Integer.toString(i), "artist"+Integer.toString(i)); // Automatically defines e.g. song1, song2, etc.
                        pldbg.addNode(dbgSong);
                    }

                    Playlist.plGlobal.add(pldbg);

                    System.out.print("Debug playlist created!");
                    break;
                default:
                    System.out.println("Invalid selection!");
                    break;
            } playlistMenu();

        } catch(InputMismatchException ex) {
            System.out.println("Invalid input type!");
            playlistMenu();
        }
    }

    public static void playMenu() {
        System.out.println(
                "---------------\n"
            +   "Play Menu\n"
            +   "---------------\n"
            +   "0 - Return to main menu\n"
            +   "1 - Play (linear)\n"
            +   "2 - Play (loop)\n"
        );

        try {
            int in = sc.nextInt();

            switch (in) {
                case 0:
                    mainMenu();
                    break;
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
            } playMenu();
            
        } catch(InputMismatchException ex) {
            System.out.println("Invalid input type!");
            playMenu();
        }
    }
}
