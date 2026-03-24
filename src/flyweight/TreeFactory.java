package flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    private static final Map<String, TreeFlyweight> flyweights = new HashMap<>();

    public static TreeFlyweight getFlyweight(String species, String color, String bark) {
        String key = species + " " + color + " " + bark;
        return flyweights.computeIfAbsent(key, k -> new TreeFlyweight(species, color, bark));
    }
}
