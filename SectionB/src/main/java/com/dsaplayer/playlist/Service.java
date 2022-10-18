package com.dsaplayer.playlist;

import com.dsaplayer.playlist.Playlist.PlaylistNode;

public class Service {
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

    public Playlist findPlaylist(String pln) {
        if(Playlist.plGlobal != null) {
            for(int i = 0; i <= Playlist.plGlobal.size() - 1; i++) {
                if(Playlist.plGlobal.get(i).plname == pln) {
                    return Playlist.plGlobal.get(i);
                }
            }
            return null;
        } else {
            return null;
        }
    }
}
