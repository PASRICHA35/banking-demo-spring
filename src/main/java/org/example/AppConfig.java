package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.example"})
public class AppConfig {

//    @Bean("customerService") // for singleton
////    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE) //for prototype, differenct instances of this bean
//    public CustomerService getCustomerService() {
//        //always use bean inside DefaultCustomerService like below, never use new CustomerRepositoryDB.
//        CustomerService service = new DefaultCustomerService(getCustomerRepositoryDB());
//        return service;
//    }
//
//    @Bean("customerRepository")
//    public CustomerRepository getCustomerRepositoryDB() {
//        return new CustomerRepositoryDB();
//    }

}