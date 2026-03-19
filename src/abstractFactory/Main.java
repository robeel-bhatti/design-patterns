package abstractFactory;

public class Main {

    public static void main(String[] args) {
        ThemeFactory themeFactory = new LightFactory();
        themeFactory.createColor().apply();
        themeFactory.createFont().render();
    }
}
