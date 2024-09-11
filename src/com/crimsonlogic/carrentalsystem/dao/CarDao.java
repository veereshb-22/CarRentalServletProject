package com.crimsonlogic.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crimsonlogic.carrentalsystem.models.Car;
import com.crimsonlogic.carrentalsystem.models.Driver;
import com.crimsonlogic.carrentalsystem.utils.JdbcUtils;

public class CarDao {
	

	
	public int registerCar(Car car) throws ClassNotFoundException {	
		String INSERT_USERS_SQL = "INSERT INTO car "
				+ "(car_id, driver_id, car_number, car_model,car_type) VALUES(?,?,?,?,?);";
				int result = 0;
		try (Connection connection = JdbcUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1,car.getCardID());
			preparedStatement.setString(2,car.getCarDriverID());
			preparedStatement.setString(3,car.getCarNumber());
			preparedStatement.setString(4,car.getCarModel());
			preparedStatement.setString(5,car.getCarType());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {	
			JdbcUtils.printSQLException(e);
		}
		return result;
	}
	
	
	 public List<Car> getAllCar() throws ClassNotFoundException {
	        String SELECT_ALL_DRIVER = "SELECT * FROM Car";
	        List<Car> cars = new ArrayList<>();

	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRIVER)) {

	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                String cardID = rs.getString("car_id");
	                String carDriverID = rs.getString("driver_id");
	                String carNumber = rs.getString("car_number");
	                String carModel = rs.getString("car_model");
	                String carType=rs.getString("car_type");
	                Car car= new Car(cardID, carDriverID, carNumber, carModel, carType);	               
	                cars.add(car);
	            }
	        } catch (SQLException e) {
	            JdbcUtils.printSQLException(e);
	        }
	        return cars;
	 }
	
	 public String getCarIdbyNumber(String carNumber) {
		 String carId=null;
		 String SELECT_BY_NUMBER="SELECT car_id FROM car WHERE car_number = ? ;";
	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NUMBER)) {
	        	preparedStatement.setString(1,carNumber);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	carId=rs.getString("car_id");
	            }
	        }catch (SQLException e) {	
				JdbcUtils.printSQLException(e);
			}
		 return carId;
	 }
	 
	public String getDriverNameByNummber(String carNumber) {
		String SELECT_DRIVER_BY_NUMBER= "SELECT d.driver_name " +
                "FROM car c " +
                "JOIN driver d ON c.driver_id = d.driver_id " +
                "WHERE c.car_id = ?";

		String driverName=null;
		try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DRIVER_BY_NUMBER)) {
	        	preparedStatement.setString(1,carNumber);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	driverName=rs.getString("driver_name");
	            }
	        }catch (SQLException e) {	
				JdbcUtils.printSQLException(e);
			}
		return driverName;
	}
	
	public String getCarModel(String carNumber) {
		String SELECT_DRIVER_BY_NUMBER= "SELECT car_model FROM car WHERE car_id = ?";

		String carModel=null;
		try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DRIVER_BY_NUMBER)) {
	        	preparedStatement.setString(1,carNumber);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	carModel=rs.getString("car_model");
	            }
	        }catch (SQLException e) {	
				JdbcUtils.printSQLException(e);
			}
		return carModel;
	}
	

	 public List<Car> getAllCarForDriver(String driverId) throws ClassNotFoundException {
	        String SELECT_ALL_DRIVER = "SELECT * FROM Car where driver_id=? ";
	        List<Car> cars = new ArrayList<>();

	        try (Connection connection = JdbcUtils.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRIVER)) {
	        	preparedStatement.setString(1,driverId);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                String cardID = rs.getString("car_id");
	                String carNumber = rs.getString("car_number");
	                String carModel = rs.getString("car_model");
	                String carType=rs.getString("car_type");
	                Car car= new Car(cardID, carNumber, carModel, carType);	               
	                cars.add(car);
	            }
	        } catch (SQLException e) {
	            JdbcUtils.printSQLException(e);
	        }
	        return cars;
	 }
	 
	 public String getCarTypeByCarNumber(String carNumber)  {
	     	String query = "SELECT car_type FROM car WHERE car_number = ?";
	        String model=null;
	     	try (Connection connection = JdbcUtils.getConnection();
	        		PreparedStatement stmt = connection.prepareStatement(query)) {
	     			stmt.setString(1, carNumber);
	            	ResultSet rs = stmt.executeQuery();
	                if (rs.next()) {
	                    model= rs.getString("car_type");
	                } else {
	                    throw new SQLException("No car found with car number: " + carNumber);
	                }
	            
	        }catch(SQLException  e) {
	        	JdbcUtils.printSQLException(e);
	        }
	     	return model;
	    }
	 
	 public int getPriceByModel(String carNumber) {
	        String carType =getCarTypeByCarNumber(carNumber);
	        if (carType == null) {
	            return 0; // or any other value that indicates the car model was not found
	        }

	        // Define mapping from car model to integer value
	        int integerValue;
	        switch (carType) {
	            case "SUV":
	                integerValue = 10;
	                break;
	            case "Sedan":
	                integerValue = 5;
	                break;
	            case "Coupe":
	                integerValue =10;
	                break;
	            case "MPV":
	                integerValue =15;
	                break;
	            default:
	                integerValue = 0; // or any default value
	                break;
	        }

	        return integerValue;
	    }
}
