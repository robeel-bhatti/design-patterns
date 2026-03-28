package creational.abstractFactory;

public class LightFont implements ThemeFont {

    @Override
    public void render() {
        System.out.println("Applying Light Font");
    }
}
