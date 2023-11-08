package com.example.demo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="guest")
public class Guest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private long id;
	@Column(name="Phone_number")
	 private long phno;
	@Column(name="Name")
	 private String name;
	@Column(name="Gender")
	 private String gender;
	@Column(name="Email")
	 private String email;
	@Column(name="Company")
	 private String company;
	@Column(name="Address")
	 private String address;
	public long getid() {
		return id;
	}
	public void setCode(long id) {
		this.id = id;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Guest()
	{
		
	}
	public Guest( long phno, String name, String gender, String email, String company, String address) {
		super();
	
		this.phno = phno;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.company = company;
		this.address = address;
	}
	
	
	
	
}
