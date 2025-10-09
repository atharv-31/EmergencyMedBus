package com.atharv.medbus.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String location;
    private String contact;

    public User() {} // JPA needs default constructor

    public User(String name, int age, String location, String contact){
        this.name = name;
        this.age = age;
        this.location = location;
        this.contact = contact;
    }

    // Getters & setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getLocation() { return location; }
    public String getContact() { return contact; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setLocation(String location) { this.location = location; }
    public void setContact(String contact) { this.contact = contact; }
}
