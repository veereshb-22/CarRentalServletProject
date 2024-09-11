package com.cl.carrentalsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Location {
	
	private int locationId;
    
	private String startingPoint;
    
	private String endingPoint;
    
	private int locationCost;

}
