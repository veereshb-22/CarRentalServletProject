package com.crimsonlogic.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crimsonlogic.carrentalsystem.utils.JdbcUtils;

public class LocationDao {
	
	
	 public List<String> getStartingPoints() throws SQLException {
	        List<String> startingPoints = new ArrayList<>();
	        String sql = "SELECT DISTINCT starting_point FROM locations";

	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement stmt = connection.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                startingPoints.add(rs.getString("starting_point"));
	            }
	        }
	        return startingPoints;
	    }

	    
	    public List<String> getEndingPoints() throws SQLException {
	        List<String> endingPoints = new ArrayList<>();
	        String sql = "SELECT DISTINCT ending_point FROM locations ";

	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement stmt = connection.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                endingPoints.add(rs.getString("ending_point"));
	            }
	        }
	        return endingPoints;
	    }
	    
	  
	    public int getLocationCost(String startLocation, String endLocation) {
	        int cost = 0;
	        String query = "SELECT location_cost FROM locations WHERE starting_point  = ? AND ending_point = ?";

	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setString(1, startLocation);
	            preparedStatement.setString(2, endLocation);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    cost = resultSet.getInt("location_cost");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return cost;
	    }
	
}
