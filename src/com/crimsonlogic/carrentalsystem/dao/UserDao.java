package com.crimsonlogic.carrentalsystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crimsonlogic.carrentalsystem.models.User;
import com.crimsonlogic.carrentalsystem.utils.JdbcUtils;

public class UserDao { 
	public int registerUser(User users) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users "
				+ "(user_id,user_fname,user_lname,user_email,password,user_wallet,user_phone,user_age) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
				int result = 0;
		try (Connection connection = JdbcUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1,users.getUserID() );
			preparedStatement.setString(2,users.getUserFirstName() );
			preparedStatement.setString(3,users.getUserLastName() );
			preparedStatement.setString(4,users.getUserEmail());
			preparedStatement.setString(5,users.getPassword());
			preparedStatement.setInt(6, users.getUserWallet());
			preparedStatement.setString(7,users.getUserPhone());
			preparedStatement.setInt(8,users.getAge());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			JdbcUtils.printSQLException(e);
		}
		return result;
	}
	
	
	 public List<User> getAllUsers() throws ClassNotFoundException {
	        String SELECT_ALL_USERS = "SELECT * FROM users";
	        List<User> users = new ArrayList<>();

	        try (Connection connection = JdbcUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {

	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                String userID = rs.getString("user_id");
	                String userFirstName = rs.getString("user_fname");
	                String userLastName = rs.getString("user_lname");
	                String userEmail = rs.getString("user_email");
	                int userWallet = rs.getInt("user_wallet");
	                String userPhone = rs.getString("user_phone");
	                int age = rs.getInt("user_age");

	                User user = new User(userID, userFirstName, userLastName, userEmail, userWallet, userPhone, age);
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            JdbcUtils.printSQLException(e);
	        }
	        return users;
	    }
	 

	 	public void addMoneyToWallet(int money,int wallet, String useremail) {
	 		if(money>0 && wallet>0) {
				 String  SELECT_USERS = "update users set user_wallet=? where user_email=?";  
				 int k=wallet+money;
				 try (Connection connection = JdbcUtils.getConnection();
			             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS)) {
					 	preparedStatement.setInt(1,k);	
					 	preparedStatement.setString(2, useremail);
					 	preparedStatement.executeQuery();	
			        } catch (SQLException e) {
			            JdbcUtils.printSQLException(e);
		        }
	 		}
	 }
	 	
	 	
	 	
}
