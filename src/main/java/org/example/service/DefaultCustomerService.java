package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("customerService")
public class DefaultCustomerService implements CustomerService {

    //or write this for what repo we want to run.
//        @Autowired
//        @Qualifier("db")
    @Autowired
    private CustomerRepository repository;

    public DefaultCustomerService() {
    }


    // injecting the repository using the setter
    public void setCustomerRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    // injecting the repository using the constructor
//    public DefaultCustomerService(CustomerRepository repository) {
//        this.repository = repository;
//    }

    public List<Customer> getAllCustomers() {

//        Optional<Customer> optionalCustomer=repository.findById(2001L);
//        Customer customer=optionalCustomer.get();
        return repository.findAll();
    }


    public ResponseEntity<Customer> getCustomer(Long id) {
//        Optional<Customer> customerId=repository.findById(id);
//        if(customerId.isPresent())
//            return customerId.get();
//        else
//            return new Customer();

        //for handling invalid id, postman should give error of not valid id
        Optional<Customer> optionalCustomer=repository.findById(id);
        if(optionalCustomer.isPresent()){
            return new ResponseEntity<>(optionalCustomer.get(),HttpStatus.OK);
        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         throw new ResponseStatusException(HttpStatus.NOT_FOUND,"customer not found");
    }

//    public List<Customer> getAllCustomersWithStars() {
//        return repository.findAll()
//                .stream()
//                .map(c -> new Customer(c.getId(), "#####"+c.getName()+"****", c.getCity()))
//                .collect(Collectors.toList());
//    }

    public void deleteCustomer(Long id){

       repository.deleteById(id);
    }

}