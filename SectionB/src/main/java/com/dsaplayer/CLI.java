package com.dsaplayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dsaplayer.playlist.Playlist;

// Controller for the command line interface.
public class CLI {
    static Scanner sc = new Scanner(System.in);
    
    public static void mainMenu() {
        System.out.println(
                "---------------\n"
            +   "DSAPlayer CLI\n"
            +   "---------------"
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
            }

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
            +   "1 - List all playlists\n"
            +   "2 - List all songs in playlist\n"
            +   "3 - Search playlists\n"
            +   "4 - Search for song in playlist\n"
            +   "5 - Create new playlist\n"
            +   "6 - Add new song to playlist\n"
            +   "0 - [DEBUG] Create sample playlist with 100 songs\n"
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
                    // TODO: this needs to generate anonymous objects!!
                    System.out.print("Input playlist name: ");
                    Playlist pln = new Playlist(); pln.setPlname(sc.next());    // Creates new playlist *object* with name inputted; no nodes!

                    System.out.println("Playlist created! Add songs in the menu.");
                    break;
                case 6:
                    playMenu();
                    break;
                case 0:
                    System.out.print("Input playlist name: ");
                    Playlist pldbg = new Playlist(); pldbg.setPlname(sc.next());
                    
                    for(int i = 0; i < 100; )
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
                "---------------\n"
            +   "Play Menu\n"
            +   "---------------\n"
            +   "1 - Play (linear)\n"
            +   "2 - Play (loop)\n"
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
