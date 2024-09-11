package com.crimsonlogic.carrentalsystem.models;

import java.io.Serializable;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Booking  implements  Serializable,GenerateIn{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final SecureRandom random = new SecureRandom();
	
	
	private String bookingID;
	
	private String bookingCarID;
	
	private String bookingUserID;
	
	private int bookingDistance;
	
	private String bookingStartpoint;
	
	private String bookingEndpoint;
	
	private int bookingAmount;
	
	private Date bookingDate;
	
	private Time bookingTime;
	
	private String bookingStatus;
	
	
	
	@Override	
	public String randID(String inti) {
		StringBuilder id = new StringBuilder();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10); // Generates a random digit between 0 and 9
            id.append(digit);
        }
        return inti + id.toString();

	}



	public Booking(String bookingID, String bookingCarID, String bookingUserID, int bookingDistance,
			String bookingStartpoint, String bookingEndpoint, int bookingAmount, Date bookingDate, Time bookingTime,
			String bookingStatus) {
		super();
		this.bookingID = bookingID;
		this.bookingCarID = bookingCarID;
		this.bookingUserID = bookingUserID;
		this.bookingDistance = bookingDistance;
		this.bookingStartpoint = bookingStartpoint;
		this.bookingEndpoint = bookingEndpoint;
		this.bookingAmount = bookingAmount;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.bookingStatus = bookingStatus;
	}
	
	
}
