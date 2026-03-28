package creational.singleton;

public class BillPughSingleton {

    private BillPughSingleton() {}

    // inner class is not loaded until getInstance() is called
    // no locks required, because class initialization is thread-safe
    // this approach is a good mix of performance and simplicity
    private static class SingletonHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
