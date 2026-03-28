package behavioral.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Playlist implements IteratorFactory {

    private final List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public SongIterator sequentialIterator() {
        return new SequentialIterator(new ArrayList<>(songs));
    }

    @Override
    public SongIterator shuffledIterator(long seed) {
        return new ShuffledIterator(new ArrayList<>(songs), seed);
    }

    @Override
    public SongIterator genreIterator(String genre) {
        return new GenreIterator(new ArrayList<>(songs), genre);
    }

    private static class SequentialIterator implements SongIterator {

        private final List<Song> songs;
        private int index = 0;

        public SequentialIterator(List<Song> songs) {
            this.songs = songs;
        }

        @Override
        public boolean hasNext() {
            return index < songs.size();
        }

        @Override
        public Song next() {
            if (!hasNext()) {
                throw new RuntimeException("No more songs in iterator.");
            }
            return songs.get(index++);
        }
    }

    private static class ShuffledIterator implements SongIterator {

        private final List<Song> songs;
        private int index = 0;

        public ShuffledIterator(List<Song> songs, long seed) {
            this.songs = songs;
            Collections.shuffle(this.songs, new Random(seed));
        }

        @Override
        public boolean hasNext() {
            return index < songs.size();
        }

        @Override
        public Song next() {
            if (!hasNext()) {
                throw new RuntimeException("No more songs in iterator.");
            }
            return songs.get(index++);
        }
    }

    private static class GenreIterator implements SongIterator {

        private final List<Song> songs;
        private final String genre;
        private int index = 0;

        public GenreIterator(List<Song> songs, String genre) {
            this.songs = songs;
            this.genre = genre;
            advanceToNextMatch();
        }

        @Override
        public boolean hasNext() {
            return index < songs.size();
        }

        @Override
        public Song next() {
            if (!hasNext()) {
                throw new RuntimeException("No more songs in iterator.");
            }
            Song song = songs.get(index++);
            advanceToNextMatch();
            return song;
        }

        private void advanceToNextMatch() {
            while (index < songs.size() && !songs.get(index).getGenre().equals(genre)) {
                index++;
            }
        }
    }
}
