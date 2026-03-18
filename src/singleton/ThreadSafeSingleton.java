package singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    /**
     * Thread that enters method acquires a lock.
     * Next thread waits until lock is released.
     * This is thread-safe, but can result in performance issues
     * due to locking and releasing.
     */
    public static synchronized ThreadSafeSingleton getInstance() {
       if (instance == null) {
           instance = new ThreadSafeSingleton();
       }
       return instance;
    }

}
