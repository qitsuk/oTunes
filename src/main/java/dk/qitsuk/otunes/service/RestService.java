package dk.qitsuk.otunes.service;

import java.util.ArrayList;
import java.util.Collection;

public interface RestService<T> {
    Collection<T> getAllCustomers();
    T getCustomerById(int id);
    T getCustomerByName(String firstName, String lastName);
    ArrayList<T> getCustomerSection(int offset, int limit);
    ArrayList<T> numCustomerCountry();
    T updateCustomerById(int id);
}
