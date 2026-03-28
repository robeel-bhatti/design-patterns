package creational.singleton;

/**
 * Use an enum to represent a creational.singleton
 * The recommended approach.
 *
 * The JVM guarantees that each constant
 * in an enum is created exactly once.
 *
 * INSTANCE is a single object of type Singleton
 * It's an enum constant, as well as an object, that can only be created once,
 * as guaranteed by the JVM.
 */
public enum Singleton {

    INSTANCE;

    private String name = "Singleton";

    public String getName() {
        return name;
    }

    public void doSomething() {
        System.out.println("do something");
    }
}
