package structural.flyweight;

public class TreeFlyweight {

    private final String species;

    private final String color;

    private final String bark;

    public TreeFlyweight(String species, String color, String bark) {
        this.species = species;
        this.color = color;
        this.bark = bark;
    }

    public String getSpecies() {
        return species;
    }

    public String getColor() {
        return color;
    }

    public String getBark() {
        return bark;
    }
}
