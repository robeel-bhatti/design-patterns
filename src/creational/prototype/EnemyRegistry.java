package creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {

    Map<String, Enemy> registry = new HashMap<>();

    public void register(String enemyIdent, Enemy enemyPrototype) {
        registry.put(enemyIdent, enemyPrototype);
    }

    public Enemy spawn(String enemyIdent) {
        Enemy enemy = this.registry.get(enemyIdent);
        return enemy != null ? enemy.clone() : null;
    }

}
