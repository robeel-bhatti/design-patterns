package abstractFactory;

public class DarkFont implements ThemeFont {

    @Override
    public void render() {
        System.out.println("Dark Font");
    }
}
