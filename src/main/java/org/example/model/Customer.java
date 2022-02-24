package org.example.model;

//    CTRL + b -> navigate to
//
//    CTRL + d -> duplicate
//
//    ALT + ENTER -> quick Help
//
//    ALT + Insert -> help for generating quick code
//
//    CTRL + F12

import javax.persistence.*;
import java.util.Date;

@Entity(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private Date date_of_birth;
    private String zipcode;
    private Integer status;

    private String name;
    private String city;

//    public Customer(String id, String name, String city) {
//        this.id = id;
//        this.name = name;
//        this.city = city;
//    }


    public Customer() {
    }

    public Date getDob() {
        return date_of_birth;
    }

    public void setDob(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getZip() {
        return zipcode;
    }

    public void setZip(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
