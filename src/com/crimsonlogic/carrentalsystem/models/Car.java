package com.crimsonlogic.carrentalsystem.models;

import java.io.Serializable;
import java.security.SecureRandom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Car implements Serializable,GenerateIn {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private static final SecureRandom random = new SecureRandom(); 
	
	private String cardID;
	
	private String CarDriverID;
	
	private String carNumber;
	
	private String carModel;
	
	private String carType;

	@Override
	public String randID(String inti) {
		StringBuilder id = new StringBuilder();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10); // Generates a random digit between 0 and 9
            id.append(digit);
        }
        return "CID" + id.toString();

	}

	public Car(String cardID, String carDriverID, String carNumber, String carModel, String carType) {
		super();
		this.cardID = cardID;
		CarDriverID = carDriverID;
		this.carNumber = carNumber;
		this.carModel = carModel;
		this.carType = carType;
	}

	public Car(String cardID, String carNumber, String carModel, String carType) {
		super();
		this.cardID = cardID;
		this.carNumber = carNumber;
		this.carModel = carModel;
		this.carType = carType;
	}
	
	
}
