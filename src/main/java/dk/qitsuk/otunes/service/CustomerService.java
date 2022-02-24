package dk.qitsuk.otunes.service;

import dk.qitsuk.otunes.dataaccess.models.Customer;

import java.util.Collection;

public interface CustomerService extends RestService<Customer> {
    Collection<Customer> getAllCustomer();

    Collection<Customer> searchByFirstname(String query);
}
