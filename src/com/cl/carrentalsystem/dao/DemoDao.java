package com.cl.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import com.cl.carrentalsystem.utils.JdbcUtils;

public class  DemoDao{
	
    // Database connection parameters
    
    public void saveDataTime(ZonedDateTime dateTime) {
        String sql = "INSERT INTO timeokk(date_column, time_column) VALUES (?, ?)";

        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Convert ZonedDateTime to java.sql.Timestamp
        	

                    // Extract LocalDate and LocalTime from ZonedDateTime
                    LocalDate localDate = dateTime.toLocalDate();
                    LocalTime localTime = dateTime.toLocalTime();

                    // Set LocalDate and LocalTime to the PreparedStatement
                    statement.setDate(1, java.sql.Date.valueOf(localDate));
                    statement.setTime(2, java.sql.Time.valueOf(localTime));

                    statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, possibly rethrow or log it
        }
    }
}
