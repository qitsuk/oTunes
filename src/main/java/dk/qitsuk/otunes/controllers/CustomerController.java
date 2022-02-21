package dk.qitsuk.otunes.controllers;

import dk.qitsuk.otunes.dataaccess.dataaccessobjects.CustomerDAO;
import dk.qitsuk.otunes.dataaccess.models.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CustomerController {

    private final ArrayList<Customer> customers = new ArrayList<>();
    private CustomerDAO customerDAO;

    @GetMapping("/api/getAllCustomers")
    private ArrayList<Customer> getAllCustomer() {
        customerDAO = new CustomerDAO();
        return customerDAO.getAllCustomers();
    }
    @GetMapping("/api/getCustomerById")
    private Customer getCustomerById(@RequestParam int id) {
        customerDAO = new CustomerDAO();
        return customerDAO.getCustomerById(id);
    }
    @GetMapping("/api/getCustomerByName")
    public Customer getCustomerByName(@RequestParam String firstName, String lastName) {
        customerDAO = new CustomerDAO();
        return customerDAO.getCustomerByName(firstName, lastName);
    }

}
