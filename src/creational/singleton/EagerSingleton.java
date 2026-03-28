package creational.singleton;

public class EagerSingleton {

    // instantiate when class loads
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    // global access point
    // this approach is useful when it's guaranteed to use the creational.singleton in the app
    // no locks needed
    public static EagerSingleton getInstance() {
        return instance;
    }
}
