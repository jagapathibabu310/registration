package com.mop.registration.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationRequest {

	@JsonProperty("Phone")
	private String Phone;
	@JsonProperty("Name")
	private String Name;
	@JsonProperty("Email")
	private String Email;
	@JsonProperty("DOB")
	private String DOB;
	@JsonProperty("Address")
	private String Address;
	@JsonProperty("State")
	private String State;
	@JsonProperty("City")
	private String City;
	
	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	
	
}
