package com.cl.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.cl.carrentalsystem.models.Booking;
import com.cl.carrentalsystem.utils.JdbcUtils;

public class BookingDao {
	
	public int registerBooking(Booking book) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO booking "
				+ "(booking_id, car_id, user_id, booking_date, booking_time, booking_distance, booking_startpoint, booking_endpoint,"
				+ " booking_status, booking_amount) VALUES(?,?,?,?,?,?,?,?,?,?);";
				int result = 0;
		try (Connection connection = JdbcUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1,book.getBookingID());
			preparedStatement.setString(2,book.getBookingCarID());
			preparedStatement.setString(3,book.getBookingUserID());
			preparedStatement.setDate(4,book.getBookingDate());
			preparedStatement.setTime(5, book.getBookingTime());
			preparedStatement.setInt(6,book.getBookingDistance());
			preparedStatement.setString(7,book.getBookingStartpoint());
			preparedStatement.setString(8,book.getBookingEndpoint());
			preparedStatement.setString(9,book.getBookingStatus());
			preparedStatement.setInt(10,book.getBookingAmount());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			JdbcUtils.printSQLException(e);
		}
		return result;
	}
	
	 public List<Booking> getAllBooking() throws ClassNotFoundException {
		 	String SELECT_ALL_DRIVER = "SELECT * FROM booking";
	        List<Booking> book = new ArrayList<>();	    	
	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRIVER)) {

	            ResultSet rs = preparedStatement.executeQuery();
	           
	            while (rs.next()) {
	                String bookingID= rs.getString("booking_id");
	                String bookingCarID = rs.getString("car_id");
	                String bookingUserID = rs.getString("user_id");
	                int bookingDistance = rs.getInt("booking_distance");
	                String bookingStartpoint =rs.getString("booking_startpoint");                
	                String bookingEndpoint= rs.getString("booking_endpoint");
	                int  bookingAmount= rs.getInt("booking_amount");
	                Date bookingDate= rs.getDate("booking_date");
	                Time bookingTime= rs.getTime("booking_time");
	                String bookingStatus= rs.getString("booking_status");
	                Booking bookind = new Booking( bookingID, bookingCarID,  bookingUserID,  bookingDistance,
	                bookingStartpoint, bookingEndpoint, bookingAmount,bookingDate, bookingTime, bookingStatus);
	                book.add(bookind);
	            }
	        } catch (SQLException e) {
	            JdbcUtils.printSQLException(e);
	        }
	        return book;
	    }
	 
	 
}
