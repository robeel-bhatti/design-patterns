package creational.singleton;

public class DoubleCheckedSingleton {

    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {}

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {

            // lock here, because multiple threads may pass the first check simultaneously
            // but we aren't locking the entire method here
            // slightly more complex but better performance
            synchronized (DoubleCheckedSingleton.class) {
                // do one more check in here, just in case there's a subsequent thread
                // waiting for the lock to be released. In that case the condition will be
                // false and another instance will not be created.
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
