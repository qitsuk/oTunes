package dk.qitsuk.otunes.dataaccess.models;

public class CustomerSpender {
    private String firstName;
    private String lastName;
    private float total;

    public CustomerSpender(String firstName, String lastName, float total) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.total = total;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }
}
