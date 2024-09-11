package com.cl.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cl.carrentalsystem.models.UserBookingList;
import com.cl.carrentalsystem.utils.JdbcUtils;

public class UserBookingListDao {

	    public List<UserBookingList> getUserBookingsByUserId(String userId) {
	        List<UserBookingList> userBookings = new ArrayList<>();
	        String query = "SELECT b.booking_id, d.driver_name, d.driver_phonenumber, c.car_number, " +
	                       "b.booking_startpoint, b.booking_endpoint, b.booking_amount " +
	                       "FROM booking b " +
	                       "JOIN car c ON b.car_id = c.car_id " +
	                       "JOIN driver d ON c.driver_id = d.driver_id " +
	                       "JOIN transaction t ON b.booking_id = t.booking_id " +
	                       "WHERE b.user_id = ?";
	      
	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setString(1, userId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	              
	            	while (resultSet.next()) {  
	                    String bookingId=resultSet.getString("booking_id");
	                    String driverName=resultSet.getString("driver_name");
	                    String phoneNumber=resultSet.getString("driver_phonenumber");
	                    String carNumber=resultSet.getString("car_number");
	                    String startPoint=resultSet.getString("booking_startpoint");
	                    String endPoint=resultSet.getString("booking_endpoint");
	                    int bookingAmount=resultSet.getInt("booking_amount");
	                    UserBookingList ubl=new  UserBookingList(bookingId, driverName, phoneNumber, carNumber,
	                		  startPoint, endPoint,bookingAmount);
	                    userBookings.add(ubl);
	                }
	            	
	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle exceptions appropriately in your application
	        }
	        return userBookings;
	    }
	

}
