package flyweight;

public class Tree {

    private int x;

    private int y;

    private TreeFlyweight flyweight;

    public Tree(int x, int y, String species, String color, String bark) {
        this.x = x;
        this.y = y;
        this.flyweight = TreeFactory.getFlyweight(species, color, bark);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TreeFlyweight getFlyweight() {
        return flyweight;
    }

    public void render() {
        String msg = String.format(
                "Tree at (%d,%d): [%s | %s | %s]",
                this.getX(),
                this.getY(),
                this.getFlyweight().getSpecies(),
                this.getFlyweight().getColor(),
                this.getFlyweight().getBark()
        );
        System.out.println(msg);
    }
}
