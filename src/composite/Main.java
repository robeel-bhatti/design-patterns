package composite;

public class Main {

    public static void main(String[] args) {
        IndividualContributor carol = new IndividualContributor("Carol", "Engineer", 90_000);
        IndividualContributor dave  = new IndividualContributor("Dave",  "Engineer", 95_000);
        IndividualContributor frank = new IndividualContributor("Frank", "Marketing Analyst", 70_000);

        Manager bob = new Manager("Bob", "VP Engineering", 150_000);
        bob.addEmployee(carol);
        bob.addEmployee(dave);

        Manager eve = new Manager("Eve", "VP Marketing", 140_000);
        eve.addEmployee(frank);

        Manager alice = new Manager("Alice", "CEO", 200_000);
        alice.addEmployee(bob);
        alice.addEmployee(eve);

        // Leaf checks
        assert carol.getTotalCost()  == 90_000  : "carol total cost";
        assert carol.getHeadcount()  == 1       : "carol headcount";

        // Mid-level manager
        assert bob.getTotalCost()    == 335_000 : "bob total cost";
        assert bob.getHeadcount()    == 3       : "bob headcount";

        // Root
        assert alice.getTotalCost()  == 745_000 : "alice total cost";
        assert alice.getHeadcount()  == 6       : "alice headcount";

        // Remove an employee and re-check
        bob.removeEmployee(dave);
        assert bob.getTotalCost()    == 240_000 : "bob total after remove";
        assert bob.getHeadcount()    == 2       : "bob headcount after remove";
        assert alice.getTotalCost()  == 650_000 : "alice total after remove";

        alice.print(0);
    }

}
