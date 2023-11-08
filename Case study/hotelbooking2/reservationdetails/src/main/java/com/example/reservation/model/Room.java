package com.example.reservation.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name="Room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

	



	@Id
    long id;
	
	@Column(name="no_of_adult")

	long no_of_Adult;
	@Column(name="no_of_child")
	
	
    long no_of_child;
	
	@Column(name="checkin_date")

    LocalDate check_in_date;
	
	
	@Column(name="checkout_date")
    LocalDate checkout_date;
	@NotBlank(message="room_type should not be blank")
	@Column(name="room_type")
	String room_type;
	
	@Column(name="price")
    private double price;
	
	@Column(name="Number_of_Nights")
    long Number_of_Nights;
	
	@Column(name="total_price")
	long total_price;
	
	
	
}
