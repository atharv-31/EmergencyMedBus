package com.atharv.medbus.model;

import jakarta.persistence.*;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String emergencyType;
    private String status;

    public Request() {}

    public Request(User user, String emergencyType){
        this.user = user;
        this.emergencyType = emergencyType;
        this.status = "Pending";
    }

    // Getters & setters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public String getEmergencyType() { return emergencyType; }
    public String getStatus() { return status; }

    public void setUser(User user) { this.user = user; }
    public void setEmergencyType(String emergencyType) { this.emergencyType = emergencyType; }
    public void setStatus(String status) { this.status = status; }
}
