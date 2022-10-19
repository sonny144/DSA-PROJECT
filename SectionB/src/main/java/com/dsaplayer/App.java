package com.dsaplayer;

import java.util.ArrayList;

import com.dsaplayer.playlist.Playlist;

// import com.dsaplayer.playlist.Playlist;
// import com.dsaplayer.song.Song;

public class App {
  public static ArrayList<Playlist> plGlobal; // Stub for in-file storage of playlists
  public static void main(String[] args) {
    plGlobal = new ArrayList<Playlist>();  // Init playlist globalvar
    CLI.mainMenu();

    // // For testing DLL functionality
    // Playlist plist = new Playlist();
    // Song s1 = new Song("song1", "art1");
    // Song s2 = new Song("song2", "art2");
    // Song s3 = new Song("song3", "art3");
    // Song s4 = new Song("song4", "art4");
    // plist.addNode(s1); plist.addNode(s2); plist.addNode(s3); plist.addNode(s4);
  }
}
