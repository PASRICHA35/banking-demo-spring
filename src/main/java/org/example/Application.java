//#cleanup command
//        docker rm -f $(docker ps -aq)

//#run mysql
//        docker run -d --rm -p 3306:3306 thecodecamp/customers-db:latest

//for status
//docker ps -a

package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);


    }
}