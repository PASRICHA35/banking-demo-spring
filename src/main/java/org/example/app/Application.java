package org.example.app;

import org.example.model.Customer;
import org.example.repository.CustomerRepositoryDB;
import org.example.repository.CustomerRepositoryStub;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;

import java.util.List;

//Ioc Container(Inversion of Control)
public class Application {

    public static void main(String[] args) {

//        CustomerRepositoryStub stubRepository = new CustomerRepositoryStub();
//        CustomerRepositoryDB dbRepository = new CustomerRepositoryDB();


        // DESIGN PRINCIPLE: Always program to interface and not to an implementation

        // wiring your application
//        DefaultCustomerService service = new DefaultCustomerService(dbRepository);

        //also can call like this
        CustomerService service = new DefaultCustomerService(newCustomerRepositoryStub());

//    List<Customer> customers = service.getAllCustomersWithStars();
        List<Customer> customers = service.getAllCustomers();

        customers.forEach(System.out::println);

    }

    //aslo can call like this bcoz its IOC.
    public static CustomerRepositoryDB newCustomerRepositoryDB() {
        return new CustomerRepositoryDB();
    }

    public static CustomerRepositoryStub newCustomerRepositoryStub() {
        return new CustomerRepositoryStub();
    }
}