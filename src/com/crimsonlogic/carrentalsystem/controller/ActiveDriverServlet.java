package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimsonlogic.carrentalsystem.dao.DriverDao;
import com.crimsonlogic.carrentalsystem.models.Driver;

/**
 * Servlet implementation class ValidateUserServlet
 */
@WebServlet("/activedriverservlet")
public class ActiveDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	 private DriverDao driverdao;

	    public void init() {
	        driverdao = new DriverDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	            List<Driver> drivers = driverdao.getAllValidDriver();
	            request.setAttribute("drivers", drivers);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/drivervalidation.jsp");
	            dispatcher.forward(request, response);
	        } catch (ClassNotFoundException e) {
	            throw new ServletException(e);
	        }
	    }
	

}
