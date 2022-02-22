package dk.qitsuk.otunes.controllers;

import dk.qitsuk.otunes.dataaccess.dataaccessobjects.CustomerDAO;
import dk.qitsuk.otunes.dataaccess.models.Customer;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CustomerController {

    private final ArrayList<Customer> customers = new ArrayList<>();
    private CustomerDAO customerDAO;

    @GetMapping("/api/getAllCustomers")
    @Operation(summary = "Get all customers from the DB.")
    private ArrayList<Customer> getAllCustomer() {
        customerDAO = new CustomerDAO();
        return customerDAO.getAllCustomers();
    }
    @GetMapping("/api/getCustomerById")
    @Operation(summary = "Get customer by ID.")
    private Customer getCustomerById(@RequestParam int id) {
        customerDAO = new CustomerDAO();
        return customerDAO.getCustomerById(id);
    }
    @GetMapping("/api/getCustomerByName")
    @Operation(summary = "Get customer by name.")
    public Customer getCustomerByName(@RequestParam String firstName, String lastName) {
        customerDAO = new CustomerDAO();
        return customerDAO.getCustomerByName(firstName, lastName);
    }
    @GetMapping("/api/getCustomerSection")
    @Operation(summary = "Get a section of the customer table with and offset and a limit.")
    public ArrayList<Customer> getCustomerSection(@RequestParam int offset, int limit) {
        customerDAO = new CustomerDAO();
        return customerDAO.getCustomerSection(offset, limit);
    }



}
