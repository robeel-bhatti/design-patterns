package structural.decorator;

public class Main {

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        CoffeeDecorator sugarDecorator = new SugarDecorator(new MilkDecorator(coffee));

        sugarDecorator.getCost();
        sugarDecorator.getDescription();

    }
}
