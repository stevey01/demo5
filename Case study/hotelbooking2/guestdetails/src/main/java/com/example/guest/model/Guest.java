package com.example.guest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="guest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

	@Id
	
     private long id;
	@Column(name="Phone_number")
	 private long phno;

	@NotBlank(message="name should not be blank")
	@Column(name="Name")
	
	 private String name;
	@Column(name="Gender")
	 private String gender;
	@Email(message = "Please enter a valid email Id ", regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	@Column(name="Email")
	@NotBlank(message="name should not be blank")
	 private String email;
	@NotBlank(message="company name should not be blank")
	@Column(name="Company")
	 private String company;
	@NotBlank(message="address should not be blank")
	@Column(name="Address")
	 private String address;
	
	
	
	
	
	
	
}
