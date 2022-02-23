package dk.qitsuk.otunes.dataaccess.models;

public class CustomerSpender {
    private int CustomerId;
    private float Total;

    public CustomerSpender(int CustomerID, float Total) {
        this.CustomerId = CustomerID;
        this.Total = Total;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }
}
