package com.bhlieberman.songr.albums;

import java.io.Serializable;
import java.net.URL;

public class Album implements Serializable {
    String title;
    String artist;
    int songCount;
    long length;
    URL imageURL;

    public Album(String title, String artist, int songCount, long length, URL imageURL) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return this.title + " is by " + this.artist;
    }
}
