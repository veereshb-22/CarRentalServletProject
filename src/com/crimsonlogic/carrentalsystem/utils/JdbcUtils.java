package com.crimsonlogic.carrentalsystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	
	private static String jdbcURL = "jdbc:postgresql://localhost:5432/CRS";
	private static String jdbcUserName = "postgres";
	private static String jdbcPassword = "crimson@123";
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
			
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return conn;
	}

	public static void printSQLException(SQLException se){
		for(Throwable te:se){
			if(te instanceof SQLException){
				te.printStackTrace(System.err);
				System.err.println("SQLState : "+ ((SQLException) te).getSQLState());
				System.err.println("Error Code : " + ((SQLException) te).getErrorCode());
				System.err.println("Message : " + te.getMessage());
				Throwable t =  se.getCause();
				while(t!=null){
					System.out.println("Cause : " + t.getCause());
				}
			}
		}
	}

}
