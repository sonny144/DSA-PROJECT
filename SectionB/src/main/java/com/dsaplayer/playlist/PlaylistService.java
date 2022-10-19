package com.dsaplayer.playlist;

import com.dsaplayer.App;
import com.dsaplayer.playlist.Playlist.PlaylistNode;

public class PlaylistService {
    // create_playlist as shown in pseudocode is located in Playlist.java due to access issues
    public void playTrack(Playlist pl, String key) {
        
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
        System.out.println("test1");
        if(App.plGlobal != null) {
            System.out.println("test2");
            for(int i = 0; i <= App.plGlobal.size() - 1; i++) {
                System.out.println("test3");
                System.out.println("*"+App.plGlobal.get(i).getPlname()+"*&*"+pln+"*");
                if(App.plGlobal.get(i).getPlname().equals(pln)) {
                    System.out.println("!!HIT!!");
                    return App.plGlobal.get(i);
                }
            }
            return null;
        } else {
            return null;
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
