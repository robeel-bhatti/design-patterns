package decorator;

public class SimpleCoffee implements Coffee {

    @Override
    public void getDescription() {
        System.out.println("This is simple");
    }

    @Override
    public void getCost() {
        System.out.println("Cost is 1 dollar");
    }
}
