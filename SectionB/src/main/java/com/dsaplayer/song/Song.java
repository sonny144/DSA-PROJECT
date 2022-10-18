package com.dsaplayer.song;

import java.io.File;

// model for songs; every song's details are stored in memory as an object
public class Song {
    private File file;
    private String name;
    // private String artist;

    // standard getters/setters
    // note: getFile returns a file *object*
    public File getFile()                   {return file;}
    public void setFile(File file)          {this.file = file;} // only exists for debug
    
    public String getName()                 {return name;}
    public void setName(String name)        {this.name = name;}

    // public String getArtist()               {return artist;}
    // public void setArtist(String artist)    {this.artist = artist;}

    // initialises `file` by filepath; acts as setter for file during runtime
    public Song(String path, String nm) {
        file = new File(Song.class.getResource(path).getFile());
        name = nm;
    }
    
    // displays song details
    // @Override
    // public String toString() {
    //     return "{Song [Name: "+name+"; Artist: "+artist+"] @ "+file+"}";
    // }

    // displays song details
    @Override
    public String toString() {
        return "{Song: "+file+"}";
    }
}
