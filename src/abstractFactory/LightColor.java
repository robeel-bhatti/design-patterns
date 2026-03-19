package abstractFactory;

public class LightColor implements ThemeColor {

    @Override
    public void apply() {
        System.out.println("Applying light color");
    }
}
