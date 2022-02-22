package dk.qitsuk.otunes.dataaccess.models;

public class CountryCount {
    private int numberOfCustomers;
    private String country;

    public CountryCount(int numberOfCustomers, String country) {
        this.numberOfCustomers = numberOfCustomers;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
}
