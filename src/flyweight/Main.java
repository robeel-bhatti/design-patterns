package flyweight;

public class Main {

    public static void main(String[] args) {

        Forest forest = new Forest();

        forest.plantTree(0,  5,  "Oak",   "dark green", "rough bark");
        forest.plantTree(3,  8,  "Oak",   "dark green", "rough bark");
        forest.plantTree(7,  2,  "Pine",  "bright green", "smooth bark");
        forest.plantTree(1,  9,  "Pine",  "bright green", "smooth bark");
        forest.plantTree(4,  4,  "Oak",   "dark green", "rough bark");
        forest.plantTree(6,  6,  "Birch", "pale yellow", "papery bark");
        forest.plantTree(2,  3,  "Birch", "pale yellow", "papery bark");
        forest.plantTree(9,  1,  "Pine",  "bright green", "smooth bark");

        // Expected:
        // Tree at (0,5): [Oak | dark green | rough bark]
        // Tree at (3,8): [Oak | dark green | rough bark]
        // Tree at (7,2): [Pine | bright green | smooth bark]
        // Tree at (1,9): [Pine | bright green | smooth bark]
        // Tree at (4,4): [Oak | dark green | rough bark]
        // Tree at (6,6): [Birch | pale yellow | papery bark]
        // Tree at (2,3): [Birch | pale yellow | papery bark]
        // Tree at (9,1): [Pine | bright green | smooth bark]
        forest.render();

        System.out.println();

        // 8 trees planted, but only 3 unique species objects should exist.
        // Expected:
        // Trees planted: 8
        // Unique species objects: 3
        System.out.println("Trees planted: " + forest.getTreeCount());
        System.out.println("Unique species objects: " + forest.getSpeciesCount());

        System.out.println();

        // The 3 Oak trees must share the exact same species object in memory.
        // The 3 Pine trees must share the exact same species object in memory.
        // The 2 Birch trees must share the exact same species object in memory.
        // Expected:
        // All Oaks share one object: true
        // All Pines share one object: true
        // Both Birches share one object: true
        // Oak and Pine are different objects: true
        System.out.println("All Oaks share one object: "    + forest.allShareSpecies("Oak"));
        System.out.println("All Pines share one object: "   + forest.allShareSpecies("Pine"));
        System.out.println("Both Birches share one object: " + forest.allShareSpecies("Birch"));
        System.out.println("Oak and Pine are different objects: " + forest.speciesDiffer("Oak", "Pine"));
    }
}
