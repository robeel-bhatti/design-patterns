package decorator;

public class MilkDecorator extends CoffeeDecorator {

    // pass in either SimpleCoffee or another decorator
    // because the superclass implements the interface Coffee,
    // you can pass in another decorator into this constructor
    // and it will be wrapped by this class.
    public MilkDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public void getDescription() {
        this.wrapped.getDescription(); // call what is has wrapped
        System.out.println("This is now a milk coffee");
    }

    @Override
    public void getCost() {
        this.wrapped.getCost();
        System.out.println("This is now 2 dollars");
    }
}
