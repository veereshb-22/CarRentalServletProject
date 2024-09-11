package com.crimsonlogic.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crimsonlogic.carrentalsystem.models.Driver;
import com.crimsonlogic.carrentalsystem.utils.JdbcUtils;

public class DriverDao {

	public int registerDriver(Driver driver) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO driver "
				+ "(driver_id, driver_name, driver_license, driver_email, driver_phonenumber) "
				+ "VALUES(?,?,?,?,?);";
				int result = 0;
		try (Connection connection = JdbcUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1,driver.getDriverID());
			preparedStatement.setString(2,driver.getDriverName() );
			preparedStatement.setString(3,driver.getDriverLicense());
			preparedStatement.setString(4,driver.getDriverEmail());
			preparedStatement.setString(5,driver.getDriverPhone());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			JdbcUtils.printSQLException(e);
		}
		return result;
	}
	
	
	 public List<Driver> getAllDriver() throws ClassNotFoundException {
	        String SELECT_ALL_DRIVER = "SELECT * FROM driver";
	        List<Driver> driver = new ArrayList<>();

	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRIVER)) {

	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                String driverID = rs.getString("driver_id");
	                String driverName = rs.getString("driver_name");
	                String driverLicense = rs.getString("driver_license");
	                String driverEmail = rs.getString("driver_email");
	                String driverPhone =rs.getString("driver_phonenumber");                
	                String driverValidation= rs.getString("driver_validation");
	               
	                Driver drivers = new Driver(driverID, driverName, driverLicense, driverEmail, driverPhone, driverValidation);
	                driver.add(drivers);
	            }
	        } catch (SQLException e) {
	            JdbcUtils.printSQLException(e);
	        }
	        return driver;
	    }
	 
	 public List<Driver> getAllValidDriver() throws ClassNotFoundException {
	        String SELECT_ALL_DRIVER = "SELECT * FROM driver";
	        List<Driver> driver = new ArrayList<>();

	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRIVER)) {

	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                String driverID = rs.getString("driver_id");
	                String driverName = rs.getString("driver_name");
	                String driverLicense = rs.getString("driver_license");
	                String driverEmail = rs.getString("driver_email");
	                String driverPhone =rs.getString("driver_phonenumber");                
	                String driverValidation= rs.getString("driver_validation");
	                if(driverValidation.equals("Active")) {
	                Driver drivers = new Driver(driverID, driverName, driverLicense, driverEmail, driverPhone, driverValidation);
	                driver.add(drivers);
	                }
	            }
	        } catch (SQLException e) {
	            JdbcUtils.printSQLException(e);
	        }
	        return driver;
	    }
	 
	
	 public void inactiveDriver(String id) {
		 
		 		String  UPDATE_DRIVER = "update driver set driver_validation=? where driver_id=?";  		
				 try (Connection connection = JdbcUtils.getConnection();
			             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DRIVER)) {
					 	preparedStatement.setString(1,"InActivate");	
					 	preparedStatement.setString(2,id);
					 	preparedStatement.executeQuery();	
			        } catch (SQLException e) {
			            JdbcUtils.printSQLException(e);
		        }
	 		
	 }
}
