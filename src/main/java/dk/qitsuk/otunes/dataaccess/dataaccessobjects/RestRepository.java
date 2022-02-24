package dk.qitsuk.otunes.dataaccess.dataaccessobjects;

import java.util.ArrayList;
import java.util.Collection;

//T = Types of elements in the collection.
public interface RestRepository <T> {
    Collection<T> getAllCustomers();
    T getCustomerById(int id);
    T getCustomerByName(String firstName, String lastName);
    ArrayList<T> getCustomerSection(int offset, int limit);
    ArrayList<T> numCustomerCountry();
    T updateCustomerById(int id);

}
