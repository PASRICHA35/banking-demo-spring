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

@Entity(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String name;
    private String city;

//    public Customer(String id, String name, String city) {
//        this.id = id;
//        this.name = name;
//        this.city = city;
//    }


    public Customer() {
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
