package behavioral.iterator;

/**
 * ITERATOR PATTERN — Practice Problem: Playlist with Multiple Traversals
 *
 * SCENARIO:
 * You have a Playlist that stores songs. The internal storage is up to you.
 * The twist: the SAME playlist must support multiple ways of iterating
 * WITHOUT exposing its internals or changing its structure:
 *
 *   1. Sequential — songs in the order they were added
 *   2. Shuffled — a seeded random order (seed provided so output is deterministic)
 *   3. Genre-filtered — only songs matching a given genre, in insertion order
 *
 * Each iterator must implement hasNext() and next().
 * The playlist must provide a creational.factory method for each traversal type.
 *
 * Figure out: what's the iterator interface, what are the concrete iterators,
 * and how does the playlist hand them out without leaking its internal list?
 */
public class Main {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Bohemian Rhapsody", "Queen", "Rock"));
        playlist.addSong(new Song("So What", "Miles Davis", "Jazz"));
        playlist.addSong(new Song("Smells Like Teen Spirit", "Nirvana", "Rock"));
        playlist.addSong(new Song("Take Five", "Dave Brubeck", "Jazz"));
        playlist.addSong(new Song("Blinding Lights", "The Weeknd", "Pop"));
        playlist.addSong(new Song("Back in Black", "AC/DC", "Rock"));
        playlist.addSong(new Song("Billie Jean", "Michael Jackson", "Pop"));
        playlist.addSong(new Song("My Favorite Things", "John Coltrane", "Jazz"));

        // --- Sequential iteration: insertion order ---
        // Expected:
        // [Sequential]
        // Bohemian Rhapsody - Queen (Rock)
        // So What - Miles Davis (Jazz)
        // Smells Like Teen Spirit - Nirvana (Rock)
        // Take Five - Dave Brubeck (Jazz)
        // Blinding Lights - The Weeknd (Pop)
        // Back in Black - AC/DC (Rock)
        // Billie Jean - Michael Jackson (Pop)
        // My Favorite Things - John Coltrane (Jazz)
        System.out.println("[Sequential]");
        SongIterator sequential = playlist.sequentialIterator();
        while (sequential.hasNext()) {
            System.out.println(sequential.next());
        }

        System.out.println();

        // --- Calling next() when exhausted must throw ---
        // Expected: No more songs in iterator.
        try {
            sequential.next();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // --- Genre-filtered: only Rock songs, in insertion order ---
        // Expected:
        // [Rock only]
        // Bohemian Rhapsody - Queen (Rock)
        // Smells Like Teen Spirit - Nirvana (Rock)
        // Back in Black - AC/DC (Rock)
        System.out.println("[Rock only]");
        SongIterator rockOnly = playlist.genreIterator("Rock");
        while (rockOnly.hasNext()) {
            System.out.println(rockOnly.next());
        }

        System.out.println();

        // --- Genre-filtered: only Jazz songs ---
        // Expected:
        // [Jazz only]
        // So What - Miles Davis (Jazz)
        // Take Five - Dave Brubeck (Jazz)
        // My Favorite Things - John Coltrane (Jazz)
        System.out.println("[Jazz only]");
        SongIterator jazzOnly = playlist.genreIterator("Jazz");
        while (jazzOnly.hasNext()) {
            System.out.println(jazzOnly.next());
        }

        System.out.println();

        // --- Genre with no matches returns an iterator that is immediately exhausted ---
        // Expected:
        // [Country only]
        // No country songs found: true
        System.out.println("[Country only]");
        SongIterator countryOnly = playlist.genreIterator("Country");
        System.out.println("No country songs found: " + !countryOnly.hasNext());

        System.out.println();

        // --- Shuffled: deterministic with seed 42 ---
        // The shuffled iterator takes a seed so the order is reproducible.
        // Expected:
        // [Shuffled (seed=42)]
        // Take Five - Dave Brubeck (Jazz)
        // So What - Miles Davis (Jazz)
        // Smells Like Teen Spirit - Nirvana (Rock)
        // Blinding Lights - The Weeknd (Pop)
        // Back in Black - AC/DC (Rock)
        // Billie Jean - Michael Jackson (Pop)
        // My Favorite Things - John Coltrane (Jazz)
        // Bohemian Rhapsody - Queen (Rock)
        System.out.println("[Shuffled (seed=42)]");
        SongIterator shuffled = playlist.shuffledIterator(42);
        while (shuffled.hasNext()) {
            System.out.println(shuffled.next());
        }

        System.out.println();

        // --- Multiple iterators are independent ---
        // Two sequential iterators on the same playlist don't interfere.
        // Expected:
        // [Independence check]
        // iter1: Bohemian Rhapsody - Queen (Rock)
        // iter1: So What - Miles Davis (Jazz)
        // iter2: Bohemian Rhapsody - Queen (Rock)
        // iter1: Smells Like Teen Spirit - Nirvana (Rock)
        // iter2: So What - Miles Davis (Jazz)
        System.out.println("[Independence check]");
        SongIterator iter1 = playlist.sequentialIterator();
        SongIterator iter2 = playlist.sequentialIterator();

        System.out.println("iter1: " + iter1.next());
        System.out.println("iter1: " + iter1.next());
        System.out.println("iter2: " + iter2.next());
        System.out.println("iter1: " + iter1.next());
        System.out.println("iter2: " + iter2.next());
    }
}
