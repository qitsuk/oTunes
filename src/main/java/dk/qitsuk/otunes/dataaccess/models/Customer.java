package dk.qitsuk.otunes.dataaccess.models;

public class Customer {
    // Keeping all fields private, for better encapsulation.
    private int id;
    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String email;

    // A public constructor, to instantiate instances of the Customer.
    public Customer(String firstName, String lastName, String country, String postalCode, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
   /* public Customer(int id, String firstName, String lastName, String country, String postalCode, String phoneNumber, String email) {
        this(firstName, lastName, country, postalCode, phoneNumber, email);
        this.id = id;
    }*/

    // region Getters and Setters
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCountry() {
        return country;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
    // endregion
}
