package com.crimsonlogic.carrentalsystem.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDriverInfo {

		private String carModel;
	    
		private String carNumber;
	    
		private String driverName;
	    
		private String driverPhoneNumber;
		
		private int rideCost;
		
	    public CarDriverInfo(String carModel, String carNumber, String driverName, String driverPhoneNumber, int rideCost) {	       
	    	this.carModel = carModel;
	        this.carNumber = carNumber;
	        this.driverName = driverName;
	        this.driverPhoneNumber = driverPhoneNumber;
	        this.rideCost=rideCost;
	    }

	}


