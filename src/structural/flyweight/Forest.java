package structural.flyweight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Forest {

    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String species, String color, String bark) {
        Tree tree = new Tree(x, y, species, color, bark);
        trees.add(tree);
    }

    public void render() {
        for (Tree tree : trees) {
            tree.render();
        }
    }

    public int getTreeCount() {
        return trees.size();
    }

    public int getSpeciesCount() {
        Set<TreeFlyweight> seen = new HashSet<>();
        trees.forEach(t -> seen.add(t.getFlyweight()));
        return seen.size();
    }

    public boolean allShareSpecies(String species) {
        if (species.isBlank()) {
            return false;
        }

        Tree speciesTree = null;
        for (Tree tree : trees) {
            if (tree.getFlyweight().getSpecies().equals(species)) {
                if (speciesTree == null) {
                    speciesTree = tree;
                } else if (speciesTree.getFlyweight() != tree.getFlyweight()) {
                    return false;
                }
            }
        }
        return speciesTree != null;
    }

    public boolean speciesDiffer(String species1, String species2) {
        if (species1.isBlank() || species2.isBlank()) {
            return false;
        }

        TreeFlyweight flyweightOne = null;
        TreeFlyweight flyweightTwo = null;

        for (Tree tree : trees) {
            if (tree.getFlyweight().getSpecies().equals(species1)) {
                flyweightOne = tree.getFlyweight();
            } else if (tree.getFlyweight().getSpecies().equals(species2)) {
                flyweightTwo = tree.getFlyweight();
            }
        }

        if (flyweightOne == null && flyweightTwo == null) {
            return false;
        }

        return flyweightOne != flyweightTwo;
    }
}
