package com.dsaplayer.playlist;

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

    public Playlist givePlaylist(int i) {
        if(Playlist.plGlobal != null) {
            return Playlist.plGlobal.get(i);
        } else {
            return null;
        }
    }

    // Ugly little static output function
    public void dumpSongsInPlaylist(Playlist pl) {
        if(Playlist.plGlobal != null) {
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
