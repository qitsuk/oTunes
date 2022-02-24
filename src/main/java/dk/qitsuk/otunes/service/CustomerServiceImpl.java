package dk.qitsuk.otunes.service;

import dk.qitsuk.otunes.dataaccess.dataaccessobjects.CustomerRepository;
import dk.qitsuk.otunes.dataaccess.models.Customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(
            CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Collection<Customer> getAllCustomer() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Collection<Customer> searchByCompanyName(String query) {
        if (query == null || query.equals("")) {
            return null; // Should really throw an exception
        }

        return customerRepository.search("CompanyName", query);
    }

    @Override
    public Customer getById(String id) {
        if (id == null || id.equals("")) {
            return null; // Should really throw an exception
        }

        return customerRepository.getById(id);
    }

    @Override
    public Customer add(Customer item) {
        // TODO Validation
        return customerRepository.add(item);
    }

    @Override
    public Customer update(Customer item) {
        if (item.getCustomerId() == null || item.getCustomerId().equals("")) {
            return null; // Should really throw an exception
        }

        int result = customerRepository.update(item);

        if (result > 0) {
            return customerRepository.getById(item.getCustomerId());
        }

        return null; // No update done.
    }

    @Override
    public Customer partialUpdate(Customer item) {
        if (item.getCustomerId() == null || item.getCustomerId().equals("")) {
            return null; // Should really throw an exception
        }

        Customer customer = customerRepository.getById(item.getCustomerId());

        if (customer == null) {
            return null; // Should really throw an exception
        }

        customer.merge(item);
        int result = customerRepository.update(customer);

        if (result > 0) {
            return customer;
        }

        return customerRepository.getById(item.getCustomerId());
    }

    @Override
    public boolean deleteById(String id) {
        return customerRepository.deleteById(id) > 0;
    }

    @Override
    public Collection<Customer> searchByFirstname(String query) {
        return null;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public Customer getCustomerByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public ArrayList<Customer> getCustomerSection(int offset, int limit) {
        return null;
    }

    @Override
    public ArrayList<Customer> numCustomerCountry() {
        return null;
    }

    @Override
    public Customer updateCustomerById(int id) {
        return null;
    }
}
