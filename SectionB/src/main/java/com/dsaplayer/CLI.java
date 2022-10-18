package com.dsaplayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dsaplayer.playlist.Playlist;

// Controller for the command line interface.
public class CLI {
    static Scanner sc = new Scanner(System.in);
    
    public static void mainMenu() {
        System.out.println(
                "---------------"
            +   "DSAPlayer CLI"
            +   "---------------"
            +   "1 - Playlist management"
            +   "2 - Play menu"
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
            }

        } catch(InputMismatchException ex) {
            System.out.println("Invalid input type!");
            mainMenu();
        }
    }

    public static void playlistMenu() {
        System.out.println(
                "---------------"
            +   "Playlist Manager"
            +   "---------------"
            +   "1 - List all playlists"
            +   "2 - List all songs in playlist"
            +   "3 - Search playlists"
            +   "4 - Search for song in playlist"
            +   "5 - Create new playlist"
            +   "6 - Add new song to playlist"
            +   "0 - [DEBUG] Create sample playlist with 100 songs"
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
                case 3:
                    playMenu();
                    break;
                case 4:
                    playMenu();
                    break;
                case 5:
                    System.out.print("Input playlist name: ");
                    Playlist pln = new Playlist(); pln.setPlname(sc.next());    // Creates new playlist *object* with name inputted; no nodes!

                    System.out.println("Playlist created! Add songs in the menu.");
                    break;
                case 6:
                    playMenu();
                    break;
                case 0:
                    System.out.print("Input playlist name: ");
                    Playlist pls = new Playlist(); pls.setPlname(sc.next());

                    break;
                default:
                    System.out.println("Invalid selection!");
                    break;
            }

        } catch(InputMismatchException ex) {
            System.out.println("Invalid input type!");
            playlistMenu();
        }
    }

    public static void playMenu() {
        System.out.println(
                "---------------"
            +   "Play Menu"
            +   "---------------"
            +   "1 - Play (linear)"
            +   "2 - Play (loop)"
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
            }
            
        } catch(InputMismatchException ex) {
            System.out.println("Invalid input type!");
            playlistMenu();
        }
    }
}
