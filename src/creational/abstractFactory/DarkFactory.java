package creational.abstractFactory;

public class DarkFactory extends ThemeFactory{

    @Override
    public ThemeColor createColor() {
        return new DarkColor();
    }

    @Override
    public ThemeFont createFont() {
        return new DarkFont();
    }
}
