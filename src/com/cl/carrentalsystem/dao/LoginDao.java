package com.cl.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cl.carrentalsystem.models.Login;
import com.cl.carrentalsystem.utils.JdbcUtils;

public class LoginDao {
	
	public  boolean validate(Login loginBean) throws ClassNotFoundException {
		
		boolean status = false;

		try (Connection connection = JdbcUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where user_email = ? and password = ? ")) {
			preparedStatement.setString(1,loginBean.getLogin_email());
			preparedStatement.setString(2,loginBean.getLogin_password());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			JdbcUtils.printSQLException(e);
		}
		return status;
	}
	

	

	 public String getNameDataByMail(String email) throws ClassNotFoundException {
	        String username = null;
	        
	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                 "SELECT user_fname FROM users WHERE user_email = ?")) {
	            
	            preparedStatement.setString(1, email);
	            System.out.println(preparedStatement);
	            try (ResultSet rs = preparedStatement.executeQuery()) {
	                if (rs.next()) {
	                    username = rs.getString("user_fname");
	                   
	                }
	            }

	        } catch (SQLException e) {
	            JdbcUtils.printSQLException(e);
	        }
	        return username;
	    }
	 

	 public int getUserWalletDataByMail(String email) throws ClassNotFoundException {
	       int userwallet=0;
	       
	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                 "SELECT user_wallet FROM users WHERE user_email = ?")) {
	            
	            preparedStatement.setString(1, email);
	            System.out.println(preparedStatement);
	            try (ResultSet rs = preparedStatement.executeQuery()) {
	                if (rs.next()) {
	                    
	                    userwallet=rs.getInt("user_wallet");
	                }
	            }

	        } catch (SQLException e) {
	            JdbcUtils.printSQLException(e);
	        }
	        return userwallet;
	    }
	
	 	public String getUserIDByEmail(String userEmail) {
	 		String SELECT_BY_ID="select user_id from users where user_email=?;";
	 		String userID=null;
	 		try (Connection connection = JdbcUtils.getConnection();
		             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
				 	preparedStatement.setString(1,userEmail);	
				 	ResultSet resultSet=preparedStatement.executeQuery();
				 	while(resultSet.next()) {
				 		userID=resultSet.getString("user_id");
				 	}
		        } catch (SQLException e) {
		            JdbcUtils.printSQLException(e);	        }
	 		return userID;
	 		
	 	}

}
