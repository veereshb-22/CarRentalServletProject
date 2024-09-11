package com.crimsonlogic.carrentalsystem.models;

import com.crimsonlogic.carrentalsystem.dao.TransactionDao;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException {
		TransactionDao td=new TransactionDao();
		System.out.println(td.getAllTransaction());
	}
}
