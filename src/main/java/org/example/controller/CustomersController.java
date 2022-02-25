package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
//        System.out.println("Customer id received is " + id);
//        return new Customer();
        //if inavlid id, handle by Response Entity or do changes in DefaultCustomerSwevice
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);

    }

}
