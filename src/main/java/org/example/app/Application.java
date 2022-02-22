//#cleanup command
//        docker rm -f $(docker ps -aq)

//#run mysql
//        docker run -d --rm -p 3306:3306 thecodecamp/customers-db:latest

//for status
//docker ps -a

package org.example.app;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.boot.web.servlet.context.XmlServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

//        CustomerRepositoryStub stubRepository = new CustomerRepositoryStub();
//        CustomerRepositoryDB dbRepository = new CustomerRepositoryDB();


        // DESIGN PRINCIPLE: Always program to interface and not to an implementation

        // wiring your application
//        DefaultCustomerService service = new DefaultCustomerService(dbRepository);

        //also can call like this
//        CustomerService service = new DefaultCustomerService(newCustomerRepositoryDB());

        //now by AppConfig
        //Ioc Container(Inversion of Control)
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //doing by xml
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        //it will convert customerService to CustomerService class.
        CustomerService service=context.getBean("customerService",CustomerService.class);
//        CustomerService service1=context.getBean("customerService",CustomerService.class);
//        CustomerService service2=context.getBean("customerService",CustomerService.class);

        //for singleton and prototype results will be diff
//        System.out.println(service);
//        System.out.println(service1);
//        System.out.println(service2);

//    List<Customer> customers = service.getAllCustomersWithStars();
        List<Customer> customers = service.getAllCustomers();

        customers.forEach(System.out::println);

    }

    //aslo can call like this bcoz its IOC.
//    public static CustomerRepositoryDB newCustomerRepositoryDB() {
//        return new CustomerRepositoryDB();
//    }
//
//    public static CustomerRepositoryStub newCustomerRepositoryStub() {
//        return new CustomerRepositoryStub();
//    }
}