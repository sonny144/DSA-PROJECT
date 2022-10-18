package com.dsaplayer.playlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dsaplayer.song.Song;

/*
This model looks a little bit complex at first glance; this is because it's not exclusively a model,
    having an embedded doubly linked list construct in the form of sub-classes called PlaylistNodes.
I couldn't find any native libraries that supported *doubly* linked lists, so I did this as a compromise--
    but it'll probably turn out to be a bit quicker than the alternative either way seeing as it would be
    stripped of the bloat.
What this additionally means is that this linkedlist is not a single object like it's typically handled as
    in Java but rather a loosely-connected group of objects.
*/
public class Playlist {
    public Playlist pl;

    // Implements doubly linked list as an embedded construct
    class PlaylistNode {
        Song song;
        PlaylistNode prev;  // Previous node
        PlaylistNode next;  // Next node

        // Technical override; defines data of dll
        public PlaylistNode(Song song) {
            this.song = song;
        }

        @Override
        public String toString() {
            return "DLL [Data: "+song+"]";
        }
    }

    // Function used to add new nodes; detects if linkedlist is headless and defines new head if so
    PlaylistNode head, tail = null;
    public void addNode(Song song) {
        PlaylistNode pn = new PlaylistNode(song);

        if(head == null) {
            head = tail = pn;
        
            head.prev   = null;
            tail.next   = null;
        } else {
            tail.next   = pn;
            pn.prev     = tail;
            tail        = pn;
            tail.next   = null;
        }
    }

    // Inserts song with new filename based on playlist file j
    public void insertSong(File file, String nm) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String j = null;    // Init to prevent exception
        while((j = br.readLine()) != null) {
            pl.addNode(new Song(j, nm));
        }

        br.close();
    }

    // Returns song at node i
    public Song get(int i) {
        return pl.get(i);
    }

    public void dumpList() {
        PlaylistNode curr = head;
        if(head == null) {
            System.out.println("WARN: Empty DLL!");
            return;
        }

        System.out.println("Nodes of DLL: ");
        while(curr != null) {
            System.out.print(curr.song+" ");
        }
    }
}
