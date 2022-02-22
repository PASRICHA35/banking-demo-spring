package org.example;

import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryDB;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean("customerService") // for singleton
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE) //for prototype, differenct instances of this bean
    public CustomerService getCustomerService() {
        //always use bean inside DefaultCustomerService like below, never use new CustomerRepositoryDB.
        CustomerService service = new DefaultCustomerService(getCustomerRepositoryDB());
        return service;
    }

    @Bean("customerRepository")
    public CustomerRepository getCustomerRepositoryDB() {
        return new CustomerRepositoryDB();
    }

}