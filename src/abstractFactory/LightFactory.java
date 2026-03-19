package abstractFactory;

public class LightFactory extends ThemeFactory {

    @Override
    public ThemeColor createColor() {
        return new LightColor();
    }

    @Override
    public ThemeFont createFont() {
        return new LightFont();
    }
}
