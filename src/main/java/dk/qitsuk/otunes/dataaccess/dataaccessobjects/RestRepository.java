package dk.qitsuk.otunes.dataaccess.dataaccessobjects;

import java.util.Collection;

//T = Types of elements in the collection.
public interface RestRepository <T> {
    Collection<T> getAllCustomer();
    T getCustomerById(int id);
    T getCustomerByName(String firstName, String lastName);
    Collection<T> getCustomerSection(int offset, int limit);
    Collection<T> getCustomerInCountry();
    T updateCustomerById(int id);







}
