package com.emergency.model;

import java.io.Serializable;

public class Patient implements Serializable {
	
	private int id;
	private String name;
	private int age;
	private String location;
	private String emergencyType;
	private String contact;
	
	public Patient() {
		
	}

	public Patient(String name, int age, String location, String emergencyType , String contact) {
	    this.name = name;
	    this.age = age;
	    this.location = location;
	    this.emergencyType = emergencyType;
	    this.contact = contact;
	    
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmergencyType() {
		return emergencyType;
	}

	public void setEmergencyType(String emergencyType) {
		this.emergencyType = emergencyType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + ", emergencyType="
				+ emergencyType + ", contact=" + contact + "]";
	}

	

	
	
}
