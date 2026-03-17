package prototype;

import java.util.List;

public class Main {

    static int passed = 0;
    static int failed = 0;

    static void check(String label, boolean condition) {
        if (condition) {
            System.out.println("  PASS: " + label);
            passed++;
        } else {
            System.out.println("  FAIL: " + label);
            failed++;
        }
    }

    public static void main(String[] args) {
        
        String dragonKey = "Dragon-Registry-Key";
        String goblinKey = "Goblin-Registry-Key";
        String trollKey = "Troll-Registry-Key";

        EnemyRegistry registry = getEnemyRegistry(dragonKey, goblinKey, trollKey);

        System.out.println("\n--- Clone returns new Object ---");
        Enemy dragonOne = registry.spawn(dragonKey);
        Enemy dragonTwo = registry.spawn(dragonKey);
        check("dragonOne and dragonTwo are not the same reference", dragonOne != dragonTwo);

        System.out.println("\n--- Primitive fields are copied correctly ---");
        check("dragonTwo health", dragonTwo.health == 500);
        check("dragonTwo damage", dragonTwo.damage == 750);
        check("dragonTwo speed", dragonTwo.speed == 1000);
        check("dragonTwo name",  dragonOne.name.equals(dragonTwo.name));

        System.out.println("\n --- Abilities list is copied, not shared ---");
        Enemy trollOne = registry.spawn(trollKey);
        Enemy trollTwo = registry.spawn(trollKey);
        trollTwo.abilities.add("poison");
        check("trollTwo has new ability", trollTwo.abilities.contains("poison"));
        check("trollOne does not have new ability", !trollOne.abilities.contains("poison"));

        System.out.println("\n --- Mutating clone primitives does not affect other clones ---");
        Enemy goblinOne = registry.spawn(goblinKey);
        Enemy goblinTwo = registry.spawn(goblinKey);
        goblinOne.health = 1;
        check("goblinOne health is 1", goblinOne.health == 1);
        check("goblinTwo health is 250", goblinTwo.health == 250);

        System.out.println("\n --- Registry returns null for unknown enemy ---");
        Enemy unknown = registry.spawn("titan");
        check("unknown enemy returns null", unknown == null);

        System.out.println("\n --- Results ---");
        System.out.println("Passed: " + passed + " / " + "Failed: " + failed);

    }

    private static EnemyRegistry getEnemyRegistry(String dragonKey, String goblinKey, String trollKey) {
        Enemy dragonPrototype = new Enemy("Dragon", 500, 750, 1000, List.of("flying", "fire-breathing", "biting"));
        Enemy goblinPrototype = new Enemy("Goblin", 250, 250, 250, List.of("eating", "kidnapping"));
        Enemy trollPrototype = new Enemy("Troll", 100, 100, 100, List.of("trolling"));

        EnemyRegistry registry = new EnemyRegistry();
        registry.register(dragonKey, dragonPrototype);
        registry.register(goblinKey, goblinPrototype);
        registry.register(trollKey, trollPrototype);
        return registry;
    }


}
