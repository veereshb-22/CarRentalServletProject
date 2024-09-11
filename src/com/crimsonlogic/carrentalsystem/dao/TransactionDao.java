package com.crimsonlogic.carrentalsystem.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.crimsonlogic.carrentalsystem.models.Car;
import com.crimsonlogic.carrentalsystem.models.Transaction;
import com.crimsonlogic.carrentalsystem.utils.JdbcUtils;

public class TransactionDao {

	
	public int registerTransaction( Transaction transcation) throws ClassNotFoundException {	
		String INSERT_USERS_SQL = "INSERT INTO  transaction"
				+ "(transaction_id, user_id, booking_id, transaction_amount) VALUES(?,?,?,?);";
				int result = 0;
		try (Connection connection = JdbcUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, transcation.getTranactionBookingID());
			preparedStatement.setString(2, transcation.getTransactionUserID());
			preparedStatement.setString(3, transcation.getTranactionBookingID());
			preparedStatement.setInt(4,  transcation.getTransactionAmount());	
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();


		} catch (SQLException e) {	
			JdbcUtils.printSQLException(e);
		}
		return result;
	}
	
	public List<Transaction> getAllTransaction() throws ClassNotFoundException {
        String SELECT_ALL_TRANSACTION = "SELECT * FROM transaction";
        List<Transaction> transactions = new ArrayList<>();

        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTION)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // Retrieve data from the ResultSet
                String transactionID = rs.getString("transaction_id");
                Timestamp transactionTime = rs.getTimestamp("transaction_time"); // Use Timestamp to capture both date and time
                String transactionStatus = rs.getString("transaction_status");
                String transactionUserID = rs.getString("user_id");
                String transactionBookingID = rs.getString("booking_id");
                int transactionAmount = rs.getInt("transaction_amount");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedTransactionTime = sdf.format(transactionTime);           
                Transaction transaction = new Transaction(transactionID, transactionUserID, transactionBookingID,formattedTransactionTime, transactionStatus, transactionAmount);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            JdbcUtils.printSQLException(e);
        }
        return transactions;
    }
	
	public List<Transaction> getAllTransaction(String user_id) throws ClassNotFoundException {
        String SELECT_ALL_TRANSACTION = "SELECT * FROM transaction";
        List<Transaction> transactions = new ArrayList<>();

        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTION)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // Retrieve data from the ResultSet
                String transactionID = rs.getString("transaction_id");
                Timestamp transactionTime = rs.getTimestamp("transaction_time"); // Use Timestamp to capture both date and time
                String transactionStatus = rs.getString("transaction_status");
                String transactionUserID = rs.getString("user_id");
                String transactionBookingID = rs.getString("booking_id");
                int transactionAmount = rs.getInt("transaction_amount");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedTransactionTime = sdf.format(transactionTime);           
                Transaction transaction = new Transaction(transactionID, transactionUserID, transactionBookingID,formattedTransactionTime, transactionStatus, transactionAmount);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            JdbcUtils.printSQLException(e);
        }
        return transactions;
    }
	 

}	

