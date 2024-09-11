package com.cl.carrentalsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.carrentalsystem.dao.DriverDao;

/**
 * Servlet implementation class DeactivateDriver
 */
@WebServlet("/deactivatedriver")    // ActiveDriverServlet
public class DeactivateDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String driverId = request.getParameter("id");
	        DriverDao driverDao = new DriverDao();
	        driverDao.inactiveDriver(driverId);
	        response.sendRedirect("activedriverservlet");
	    }

	 
	
}
