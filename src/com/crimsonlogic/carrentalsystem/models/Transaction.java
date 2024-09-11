package com.crimsonlogic.carrentalsystem.models;

import java.io.Serializable;
import java.security.SecureRandom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Transaction implements Serializable,GenerateIn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final SecureRandom random = new SecureRandom(); 
	
	private String transactionID;
	
	private String transactionUserID;
	
	private String tranactionBookingID;
	
	private String transactionTime;
	
	private String tranactionStatus;
	
	private int transactionAmount;
	
	

	@Override
	public String randID(String inti) {
		StringBuilder id = new StringBuilder();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10); // Generates a random digit between 0 and 9
            id.append(digit);
        }
        return "TID" + id.toString();

	}
	
	
	public Transaction(String transactionID, String transactionUserID, String tranactionBookingID,
			String transactionTime, String tranactionStatus, int transactionAmount) {
		super();
		this.transactionID = transactionID;
		this.transactionUserID = transactionUserID;
		this.tranactionBookingID = tranactionBookingID;
		this.transactionTime = transactionTime;
		this.tranactionStatus = tranactionStatus;
		this.transactionAmount = transactionAmount;
	}
	
	public Transaction(String transactionID, String transactionUserID,
			String tranactionBookingID, String tranactionStatus, int transactionAmount) {
		super();
		this.transactionID = transactionID;
		this.tranactionBookingID = tranactionBookingID;
		this.transactionUserID = transactionUserID;
		this.tranactionStatus = tranactionStatus;
		this.transactionAmount = transactionAmount;
	}
	
}
