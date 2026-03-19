package adapter;

public class Order {

    private String customerId;

    private double total;

    private String currency;

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getTotal() {
        return total;
    }

    public String getCurrency() {
        return currency;
    }
}
