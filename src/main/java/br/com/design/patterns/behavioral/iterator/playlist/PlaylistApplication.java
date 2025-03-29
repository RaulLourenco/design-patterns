package br.com.design.patterns.behavioral.iterator.playlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PlaylistApplication {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSongs(new Song("Yesterday", "The Beatles"));
        playlist.addSongs(new Song("Imagine", "John Lennon"));
        playlist.addSongs(new Song("Hotel California", "Eagles"));

        // Using the iterator
        for (Song song : playlist) {
            System.out.println("Now playing: " + song);
        }
    }
}

// Simple Song class
class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

// Aggregate class
class Playlist implements Iterable<Song> {
    private List<Song> songs = new ArrayList<>();

    public void addSongs(Song song) {
        songs.add(song);
    }
    @Override
    public Iterator<Song> iterator() {
        return new PlaylistIterator();
    }

    // Private inner iterator class
    private class PlaylistIterator implements Iterator<Song> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < songs.size();
        }

        @Override
        public Song next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return songs.get(currentIndex++);
        }
    }
}