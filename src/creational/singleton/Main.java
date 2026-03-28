package creational.singleton;

public class Main {

    public static void main(String[] args) {

        Singleton singleton = Singleton.INSTANCE;
        assert "singleton".equals(singleton.getName());
        singleton.doSomething();
    }
}
