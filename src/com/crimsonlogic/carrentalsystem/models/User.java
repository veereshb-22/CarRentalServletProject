package com.crimsonlogic.carrentalsystem.models;

import java.io.Serializable;
import java.security.SecureRandom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable,GenerateIn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final SecureRandom random = new SecureRandom(); 
	
	private String userID;
	
	private String userFirstName;
	
	private String userLastName;
	
	private String userEmail;
	
	private String password;
	
	private int userWallet;
	
	private String userStatus;
	
	private String userPhone;
	
	private int age;
	
	public User(String userID, String userFirstName, String userLastName, String userEmail,int userWallet,String  userPhone,int  age) {
		this.userID=userID;
		
		this.userFirstName=userFirstName;
		
		this.userLastName=userLastName;
		
		this.userEmail=userEmail;
		
		this.userWallet=userWallet;
		
		this.userPhone= userPhone;
		
		this.age=age;
		
	}
	
	@Override
	public String randID(String inti) {
		StringBuilder id = new StringBuilder();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10); // Generates a random digit between 0 and 9
            id.append(digit);
        }
        return "UID" + id.toString();
	}
	
	
}
