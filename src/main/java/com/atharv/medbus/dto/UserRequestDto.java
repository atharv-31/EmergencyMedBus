package com.atharv.medbus.dto;

public class UserRequestDto {
    private String name;
    private int age;
    private String location;
    private String contact;
    private String emergencyType;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getEmergencyType() { return emergencyType; }
    public void setEmergencyType(String emergencyType) { this.emergencyType = emergencyType; }
}
