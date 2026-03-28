package structural.decorator;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public void getDescription() {
        this.wrapped.getDescription();
        System.out.println("This is now a sugar coffee");
    }

    @Override
    public void getCost() {
        this.wrapped.getCost();
        System.out.println("This is now 3 dollars");
    }
}
