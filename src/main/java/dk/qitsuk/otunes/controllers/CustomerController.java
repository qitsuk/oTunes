package dk.qitsuk.otunes.controllers;

import dk.qitsuk.otunes.dataaccess.dataaccessobjects.CustomerRepository;
import dk.qitsuk.otunes.dataaccess.models.CountryCount;
import dk.qitsuk.otunes.dataaccess.models.Customer;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    private final ArrayList<Customer> customers = new ArrayList<>();
    private CustomerRepository customerRepository;

    @GetMapping("/api/getAllCustomers")
    @Operation(summary = "Get all customers from the DB.")
    private ArrayList<Customer> getAllCustomer() {
        customerRepository = new CustomerRepository();
        return customerRepository.getAllCustomers();
    }
    @GetMapping("/api/getCustomerById")
    @Operation(summary = "Get customer by ID.")
    private Customer getCustomerById(@RequestParam int id) {
        customerRepository = new CustomerRepository();
        return customerRepository.getCustomerById(id);
    }
    @GetMapping("/api/getCustomerByName")
    @Operation(summary = "Get customer by name.")
    public Customer getCustomerByName(@RequestParam String firstName, String lastName) {
        customerRepository = new CustomerRepository();
        return customerRepository.getCustomerByName(firstName, lastName);
    }
    @GetMapping("/api/getCustomerSection")
    @Operation(summary = "Get a section of the customer table with and offset and a limit.")
    public ArrayList<Customer> getCustomerSection(@RequestParam int offset, int limit) {
        customerRepository = new CustomerRepository();
        return customerRepository.getCustomerSection(offset, limit);
    }

    @GetMapping("/api/getCustomerInCountry")
    @Operation(summary = "Get all customers in all countries and list them from most to least in each country.")
    public ArrayList<CountryCount> getCountryCount() {
        customerRepository = new CustomerRepository();
        return customerRepository.numCustomerCountry();
    }

    @PutMapping("/api/updateCustomerById")
    @Operation(summary = "Updating a customer found by id.")
    public String updateCustomerById(Customer customer, @RequestParam int id) {
        customerRepository = new CustomerRepository();
        customerRepository.updateCustomerById(customer, id);
        return "Customer updated.";
    }


}
