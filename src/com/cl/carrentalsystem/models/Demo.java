package com.cl.carrentalsystem.models;

import com.cl.carrentalsystem.dao.TransactionDao;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException {
		TransactionDao td=new TransactionDao();
		System.out.println(td.getAllTransaction());
	}
}
