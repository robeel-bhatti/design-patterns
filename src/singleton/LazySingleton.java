package singleton;

/**
 * This singleton approach lazy initializes the singleton instance
 * This approach is the simplest but is not thread-safe.
 */
public class LazySingleton {

    private static LazySingleton instance;

    // constructor is private so client cannot create singleton instance
    private LazySingleton() {}

    // global point of access to get singleton instance
    // if multiple threads access this method simultaneouslyA
    // then multiple instances can be created hence not thread-safe
    public static LazySingleton getInstance() {

        // create the singleton when first requested
        if (instance == null) {
            instance = new LazySingleton();
        }

        // return the shared instance
        return instance;
    }
}
