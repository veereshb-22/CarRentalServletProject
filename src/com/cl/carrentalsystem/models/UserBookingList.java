package com.cl.carrentalsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UserBookingList {
	
		
		private String bookingId;
	    
		private String driverName;
	    
		private String driverPhoneNumber;
	    
		private String carNumber;
	    
		private String startPoint;
	    
		private String endPoint;
	    
		private int locationCost;

		public UserBookingList(String bookingId, String driverName, String driverPhoneNumber, String carNumber,
				String startPoint, String endPoint, int locationCost) {
			super();
			this.bookingId = bookingId;
			this.driverName = driverName;
			this.driverPhoneNumber = driverPhoneNumber;
			this.carNumber = carNumber;
			this.startPoint = startPoint;
			this.endPoint = endPoint;
			this.locationCost = locationCost;
		}

	
}