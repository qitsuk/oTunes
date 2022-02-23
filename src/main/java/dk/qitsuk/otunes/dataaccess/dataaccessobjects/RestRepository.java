package dk.qitsuk.otunes.dataaccess.dataaccessobjects;

import java.util.Collection;

//T = Types of elements in the collection.
public interface RestRepository <T> {
    Collection<T> getAllCustomer();
    T getCustomerById(int Id);
    T getCustomerByName(String firstName, String lastName);
    Collection<T>





}
