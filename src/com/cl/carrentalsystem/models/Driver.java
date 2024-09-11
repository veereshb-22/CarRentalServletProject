package com.cl.carrentalsystem.models;

import java.io.Serializable;
import java.security.SecureRandom;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor



public class Driver implements  Serializable,GenerateIn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final SecureRandom random = new SecureRandom(); 
	
	private String driverID;
	
	private String driverName;
	
	private String driverLicense;
	
	private String driverEmail;
	
	private String driverPhone;
	
	private String driverValidation;
	
	@Override
	public String randID(String inti) {
		StringBuilder id = new StringBuilder();
	        for (int i = 0; i < NUMBER_LENGTH; i++) {
	            int digit = random.nextInt(10); // Generates a random digit between 0 and 9
	            id.append(digit);
	        }
	        return inti + id.toString();
	}
	
    public Driver(String driverID, String driverName,String driverLicense, String driverEmail, String driverPhone, String driverValidation) {
    	
    	this.driverID=driverID;
    	
    	this.driverName=driverName;
    	
    	this.driverLicense=driverLicense;
    	
    	this.driverEmail=driverEmail;
    	
    	this.driverPhone=driverPhone;
    	this.driverValidation=driverValidation;
    }


}
