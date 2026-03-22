package composite;

public class Manager implements Employee {

    private String name;

    private String role;

    private double salary;

    private double cost;

    private int headCount;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public double getTotalCost() {
        return this.cost;
    }

    @Override
    public int getHeadcount() {
        return this.headCount;
    }

    @Override
    public void print(int indent) {

    }
}
