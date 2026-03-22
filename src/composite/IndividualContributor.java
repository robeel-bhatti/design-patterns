package composite;

public class IndividualContributor implements Employee {

    private final String name;

    private final String role;

    private final double salary;

    public IndividualContributor(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

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
        return 0;
    }

    @Override
    public int getHeadcount() {
        return 0;
    }

    @Override
    public void print(int indent) {

    }
}
