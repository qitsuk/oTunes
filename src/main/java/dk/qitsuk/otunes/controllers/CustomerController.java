package dk.qitsuk.otunes.controllers;

import dk.qitsuk.otunes.dataaccess.models.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CustomerController {

    private ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/api/allcustomers")
    private ArrayList<Customer> getAllCustomer() {
        return customers;
    }

}
