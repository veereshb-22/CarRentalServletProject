package com.cl.carrentalsystem.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cl.carrentalsystem.models.CarDriverInfo;
import com.cl.carrentalsystem.utils.JdbcUtils;

public class CarDriverInfoDao {
    
    public List<CarDriverInfo> getAvailableCars(Date bookingDate, Time bookingTime,int bookingCost)  {
    	List<CarDriverInfo> availableCars = new ArrayList<>();
        String sql = "SELECT c.car_model, c.car_number, d.driver_name, d.driver_phonenumber " +
                     "FROM car c " +
                     "JOIN driver d ON c.driver_id = d.driver_id " +
                     "LEFT JOIN booking b ON c.car_id = b.car_id AND b.booking_date = ? AND b.booking_time = ? " +
                     "WHERE b.car_id IS NULL AND d.driver_validation = 'Active'";
        String locationsql="SELECT location_cost FROM locations where starting_point=? AND ending_point=?";
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, bookingDate);
            statement.setTime(2, bookingTime);

            ResultSet resultSet = statement.executeQuery();
            CarDao cardao=new CarDao();
            while (resultSet.next()) {
                String carModel = resultSet.getString("car_model");
                String carNumber = resultSet.getString("car_number");
                String driverName = resultSet.getString("driver_name");
                String driverPhoneNumber = resultSet.getString("driver_phonenumber");
                int cost= bookingCost + cardao.getPriceByModel(carNumber);
                CarDriverInfo carDriverInfo = new CarDriverInfo(carModel, carNumber, driverName, driverPhoneNumber,cost);
                availableCars.add(carDriverInfo);
            }
         
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions properly in production code
        }

        return availableCars;
    }
}
