package structural.decorator;

public abstract class CoffeeDecorator implements Coffee {

    // the reason this type is Coffee, is because the base object (SimpleCoffee)
    // we want to extend the functionality is of this type.

    // this allows us to wrap a decorator around it, and pass our base object
    // into the constructor of the decorators

    // the field is defined here for DRY purposes so
    // we don't need to define this field in every decorator class
    protected final Coffee wrapped;

    // set the value of the wrapped field for each decorator created
    public CoffeeDecorator(Coffee wrapped) {
        this.wrapped = wrapped;
    }

}
