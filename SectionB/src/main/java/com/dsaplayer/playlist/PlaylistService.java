package com.dsaplayer.playlist;

import com.dsaplayer.App;
import com.dsaplayer.playlist.Playlist.PlaylistNode;

public class PlaylistService {
    // create_playlist as shown in pseudocode is located in Playlist.java due to access issues
    public void playLinear(Playlist pl) {
        
    }

    public boolean findSong(Playlist pl, String key) {
        PlaylistNode curr = pl.head;

        while(curr != null) {
            if (curr.song.getName() == key) {
                return true;
            }

            curr = curr.next;
        }
        return false;
    }

    public Playlist findPlaylistByName(String pln) {
        if(App.plGlobal != null) {
            for(int i = 0; i <= App.plGlobal.size() - 1; i++) {
                if(App.plGlobal.get(i).getPlname().equals(pln)) {
                    return App.plGlobal.get(i);
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public void searchPlaylist(Playlist pl, String key) {
        if(App.plGlobal != null) {
            PlaylistNode curr = pl.head; int check = 0;
            while(curr != null) {
                if(curr.getSong().getName().contains(key) || curr.getSong().getArtist().contains(key)) {
                    System.out.println(check+" - "+curr.getSong().getName);
                    check++;
                }
            }
            System.out.println(check+" results found");
        } else {
            System.out.println("WARN: No playlists exist");
        }
    }

    public Playlist givePlaylist(int i) {
        if(App.plGlobal != null) {
            return App.plGlobal.get(i);
        } else {
            return null;
        }
    }

    // Ugly little static output function
    public void dumpSongsInPlaylist(Playlist pl) {
        if(App.plGlobal != null && pl.head != null) {
            PlaylistNode curr = pl.head;
        
            while(curr != null) {
                int i = 0;
                System.out.println(i+" - "+curr.song.getArtist()+" - "+curr.song.getName()); i++;
                curr = curr.next != null ? curr.next : null; // Elvis conditional to set curr to null if next doesn't exist
            }
        } else {
            System.out.println("Empty playlist!");
        }
    }
}
