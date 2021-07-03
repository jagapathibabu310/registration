package com.mop.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mop.registration.request.RegistrationRequest;

@Entity
@Table(name = "Registration")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RId", unique = true)
	private Long RId;
	@Column(name = "Phone")
	private String Phone;
	@Column(name = "Name")
	private String Name;
	@Column(name = "Email")
	private String Email;
	@Column(name = "DOB")
	private String DOB;
	@Column(name = "Address")
	private String Address;
	@Column(name = "City")
	private String City;
	@Column(name = "State")
	private String State;
	
	public Registration() {
	
	}

	public Long getRId() {
		return RId;
	}

	public void setRId(Long rId) {
		RId = rId;
	}

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
	

	public Registration(RegistrationRequest registrationRequest) {
		this.Phone=registrationRequest.getPhone();
		this.Name=registrationRequest.getName();
		this.Email=registrationRequest.getEmail();
		this.DOB=registrationRequest.getDOB();
		this.Address=registrationRequest.getAddress();
		this.State=registrationRequest.getState();
		this.City=registrationRequest.getCity();

	}
	
	

	@Override
	public String toString() {
		return "Registration [RId=" + RId + ", Phone=" + Phone + ", Name=" + Name + ", Email=" + Email + ", DOB=" + DOB
				+ ", Address=" + Address + ", State=" + State + ", City=" + City + "]";
	}
	
	
}
