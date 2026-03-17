package prototype;

import java.util.ArrayList;
import java.util.List;

public class Enemy implements Cloneable {

    String name;

    List<String> abilities;

    int health;

    int damage;

    int speed;

    public Enemy(String name, int health, int damage, int speed, List<String> abilities) {
        this.name = name;
        this.abilities = abilities;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

    @Override
    public Enemy clone() {
        try {
            Enemy clone = (Enemy) super.clone();
            clone.abilities = new ArrayList<>(this.abilities);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
