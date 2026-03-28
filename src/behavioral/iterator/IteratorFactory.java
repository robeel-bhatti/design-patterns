package behavioral.iterator;

public interface IteratorFactory {

    SongIterator sequentialIterator();

    SongIterator shuffledIterator(long seed);

    SongIterator genreIterator(String genre);

}
