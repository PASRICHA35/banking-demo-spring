package org.example.repository;

import org.example.model.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Repository("db")
//@Primary
@Repository
public class CustomerRepositoryDB implements CustomerRepository {
    public List<Customer> findAll() {
        List<Customer> customers=new ArrayList<>();

//        #run mysql
//        docker run -d --rm -p 3306:3306 thecodecamp/customers-db:latest

//        #cleanup command
//        docker rm -f $(docker ps -aq)

//        for status of mysql
//        docker ps -a
        // or by checking DB Navigator and refreshing it..

        //Ctrl+Alt+O
        //to optimise imports in file


        try {
            //bcoz we have banking schema
            //create connection with jdbc
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/banking?user=root&password=student");
            PreparedStatement ps=conn.prepareStatement("SELECT customer_id,name, city from customers");
            ResultSet rs= ps.executeQuery();

            while(rs.next()){
                Customer customer=new Customer(
                        rs.getString("customer_id"),
                        rs.getString("name"),
                        rs.getString("city")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
