package com.cl.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.carrentalsystem.dao.TransactionDao;
import com.cl.carrentalsystem.models.Transaction;

/**
 * Servlet implementation class TransactionDisplay
 */
@WebServlet("/transactiondisplayservlet")
public class TransactionDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private TransactionDao transactionDao;

	    public void init() {
	    	transactionDao = new TransactionDao();
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	        	List<Transaction> transaction=transactionDao.getAllTransaction();
	            request.setAttribute("transactions", transaction);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/transactiondisplay.jsp");
	            dispatcher.forward(request, response);
	        } catch (ClassNotFoundException e) {
	            throw new ServletException(e);
	        }
	    }
}
